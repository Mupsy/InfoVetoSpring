package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.ApiApplication;
import com.infoveto.classic.api.entity.Appointments;
import com.infoveto.classic.api.entity.Notifications;
import com.infoveto.classic.api.entity.Users;
import com.infoveto.classic.api.service.UsersService;
import com.infoveto.classic.api.service.AuthService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;

    private final AuthService authService;

    private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    private static final Pattern EMAIL_REGEX = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    public UsersController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("")
    public ResponseEntity<List<Users>> getAllUsers() {
        try{
            logger.info("[Users Controller] Get all users");
            return ResponseEntity.ok().body(usersService.getUsers());
        }catch(Exception e){
            logger.error("[Users Controller] Get all users failed", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id,
                                         @CookieValue(value = "authToken", required = false) String authToken) {
        try {
            if (authToken == null) return ResponseEntity.status(401).body(Map.of("error", "Token d'authentification manquant"));
            var uOpt = authService.validateTokenAndGetUser(authToken);
            if (uOpt.isEmpty()) return ResponseEntity.status(401).body(Map.of("error", "Token invalide"));
            Users caller = uOpt.get();
            if (!caller.getId().equals(id)) {
                return ResponseEntity.status(403).body(Map.of("error", "Accès non autorisé"));
            }

            Users user = usersService.getUserById(id);
            if (user == null) return ResponseEntity.status(404).body(Map.of("error", "Utilisateur non trouvé"));

            return ResponseEntity.ok(Map.of("user", user));
        } catch (Exception e) {
            logger.error("[Users Controller] Get user failed", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur"));
        }
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<?> getStats(@PathVariable String id,
                                      @CookieValue(value = "authToken", required = false) String authToken) {
        try {
            if (authToken == null) return ResponseEntity.status(401).body(Map.of("error", "Token d'authentification manquant"));
            var uOpt = authService.validateTokenAndGetUser(authToken);
            if (uOpt.isEmpty()) return ResponseEntity.status(401).body(Map.of("error", "Token invalide"));
            Users caller = uOpt.get();
            if (!caller.getId().equals(id)) {
                return ResponseEntity.status(403).body(Map.of("error", "Accès non autorisé"));
            }

            Map<String, Object> stats = usersService.getStats(id);
            return ResponseEntity.ok(Map.of("stats", stats));
        } catch (Exception e) {
            logger.error("[Users Controller] Get stats failed", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id,
                                        @CookieValue(value = "authToken", required = false) String authToken,
                                        @RequestBody Map<String, Object> body) {
        try {
            if (authToken == null) return ResponseEntity.status(401).body(Map.of("error", "Token d'authentification manquant"));
            var uOpt = authService.validateTokenAndGetUser(authToken);
            if (uOpt.isEmpty()) return ResponseEntity.status(401).body(Map.of("error", "Token invalide"));
            Users caller = uOpt.get();
            if (!caller.getId().equals(id)) {
                return ResponseEntity.status(403).body(Map.of("error", "Accès non autorisé"));
            }

            String email = (String) body.get("email");
            String firstName = (String) body.get("nom");
            String lastName = (String) body.get("prenom");

            if (firstName == null || lastName == null || email == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Le nom, prénom et email sont obligatoires"));
            }

            if (!EMAIL_REGEX.matcher(email).matches()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Format d'email invalide"));
            }

            // Check email already used by another user
            var existing = usersService.getUserByEmail(email);
            if (existing.isPresent() && !existing.get().getId().equals(id)) {
                return ResponseEntity.badRequest().body(Map.of("error", "Cette adresse email est déjà utilisée"));
            }

            Users toUpdate = new Users();
            toUpdate.setEmail(email);
            toUpdate.setFirstName(firstName);
            toUpdate.setLastName(lastName);
            toUpdate.setBirthDate((String) body.get("dateNaissance"));
            toUpdate.setPhone((String) body.get("numero"));
            toUpdate.setAddress((String) body.get("adresse"));
            toUpdate.setCity((String) body.get("ville"));
            toUpdate.setPostalCode((String) body.get("codePostal"));
            toUpdate.setGenre((String) body.get("genre"));

            Users updated = usersService.updateUser(id, toUpdate);
            if (updated == null) return ResponseEntity.status(404).body(Map.of("error", "Utilisateur non trouvé"));

            return ResponseEntity.ok(Map.of("message", "Profil mis à jour avec succès", "user", updated));
        } catch (Exception e) {
            logger.error("[Users Controller] Update user failed", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur lors de la mise à jour"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id,
                                        @CookieValue(value = "authToken", required = false) String authToken,
                                        @RequestBody Map<String, String> body,
                                        HttpServletResponse response) {
        try {
            if (authToken == null) return ResponseEntity.status(401).body(Map.of("error", "Token d'authentification manquant"));
            var uOpt = authService.validateTokenAndGetUser(authToken);
            if (uOpt.isEmpty()) return ResponseEntity.status(401).body(Map.of("error", "Token invalide"));
            Users caller = uOpt.get();
            if (!caller.getId().equals(id)) {
                return ResponseEntity.status(403).body(Map.of("error", "Accès non autorisé"));
            }

            String password = body.get("password");
            if (password == null) return ResponseEntity.badRequest().body(Map.of("error", "Mot de passe requis"));

            Users user = usersService.getUserById(id);
            if (user == null) return ResponseEntity.status(404).body(Map.of("error", "Utilisateur non trouvé"));

            if (!usersService.checkPassword(password, user.getPassword())) {
                return ResponseEntity.badRequest().body(Map.of("error", "Mot de passe incorrect"));
            }

            usersService.deleteUserAccount(id);

            Cookie cookie = new Cookie("authToken", "");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);

            return ResponseEntity.ok(Map.of("message", "Compte supprimé avec succès"));
        } catch (Exception e) {
            logger.error("[Users Controller] Delete user failed", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur lors de la suppression du compte"));
        }
    }

    @GetMapping("/{id}/activity")
    public ResponseEntity<?> getActivity(@PathVariable String id,
                                         @CookieValue(value = "authToken", required = false) String authToken) {
        try {
            if (authToken == null) return ResponseEntity.status(401).body(Map.of("error", "Token d'authentification manquant"));
            var uOpt = authService.validateTokenAndGetUser(authToken);
            if (uOpt.isEmpty()) return ResponseEntity.status(401).body(Map.of("error", "Token invalide"));
            Users caller = uOpt.get();
            if (!caller.getId().equals(id)) {
                return ResponseEntity.status(403).body(Map.of("error", "Accès non autorisé"));
            }

            Map<String, Object> activity = usersService.getActivity(id);
            return ResponseEntity.ok(Map.of("activity", activity));
        } catch (Exception e) {
            logger.error("[Users Controller] Get activity failed", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur"));
        }
    }

    @PostMapping("/check-email")
    public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> body) {
        try {
            String email = body.get("email");
            if (email == null) return ResponseEntity.badRequest().body(Map.of("error", "Email requis"));

            boolean exists = usersService.emailExists(email);
            return ResponseEntity.ok(Map.of("exists", exists));
        } catch (Exception e) {
            logger.error("[Users Controller] Check email failed", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur"));
        }
    }
}
