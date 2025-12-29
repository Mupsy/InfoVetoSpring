package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.entity.Users;
import com.infoveto.classic.api.service.AuthService;
import com.infoveto.classic.api.service.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;
    private final UsersService usersService;

    public AuthController(AuthService authService, UsersService usersService) {
        this.authService = authService;
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> body) {
        try {
            String email = (String) body.get("email");
            String password = (String) body.get("password");
            if (password == null) password = (String) body.get("motDePasse");
            String nom = (String) body.get("nom");
            String prenom = (String) body.get("prenom");

            if (email == null || password == null || nom == null || prenom == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Email, mot de passe, nom et prénom sont obligatoires"));
            }

            if (authService.findByEmail(email).isPresent()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Un compte avec cet email existe déjà"));
            }

            Users u = new Users();
            u.setEmail(email);
            u.setPassword(password);
            u.setFirstName(nom);
            u.setLastName(prenom);
            u.setGenre((String) body.get("genre"));
            u.setBirthDate((String) body.get("dateNaissance"));
            u.setPhone((String) body.get("numero"));
            u.setAddress((String) body.get("adresse"));
            u.setCity((String) body.get("ville"));
            u.setPostalCode((String) body.get("codePostal"));

            Users saved = authService.registerUser(u);

            return ResponseEntity.status(201).body(Map.of("message", "Compte créé avec succès. Vérifiez votre email pour activer votre compte.", "userId", saved.getId()));
        } catch (Exception e) {
            logger.error("Register error", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur lors de l'inscription"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body, HttpServletResponse response) {
        try {
            String email = body.get("email");
            String password = body.get("password");
            if (email == null || password == null) return ResponseEntity.badRequest().body(Map.of("error", "Email et mot de passe requis"));

            var uOpt = authService.findByEmail(email);
            if (uOpt.isEmpty()) return ResponseEntity.status(401).body(Map.of("error", "Aucun compte trouvé avec cet email. Veuillez vous inscrire d'abord.", "code", "USER_NOT_FOUND"));
            Users u = uOpt.get();

            if (!usersService.checkPassword(password, u.getPassword())) {
                return ResponseEntity.status(401).body(Map.of("error", "Mot de passe incorrect", "code", "INVALID_PASSWORD"));
            }

            if (!u.isEmailVerified()) {
                return ResponseEntity.status(401).body(Map.of("error", "Veuillez vérifier votre email avant de vous connecter", "requiresVerification", true, "code", "EMAIL_NOT_VERIFIED"));
            }

            String token = authService.generateTokenForUser(u);

            Cookie cookie = new Cookie("authToken", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge((int) (30 * 24 * 60 * 60));
            response.addCookie(cookie);

            return ResponseEntity.ok(Map.of("message", "Connexion réussie", "user", Map.of("id", u.getId(), "email", u.getEmail(), "nom", u.getFirstName(), "prenom", u.getLastName())));
        } catch (Exception e) {
            logger.error("Login error", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur lors de la connexion"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("authToken", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok(Map.of("message", "Déconnexion réussie"));
    }

    @GetMapping("/verify-email")
    public ResponseEntity<?> verifyEmail(@RequestParam("token") String token) {
        try {
            if (token == null) return ResponseEntity.badRequest().body(Map.of("error", "Token de vérification manquant"));
            boolean ok = authService.verifyEmailToken(token);
            if (!ok) return ResponseEntity.badRequest().body(Map.of("error", "Token de vérification invalide ou expiré"));
            return ResponseEntity.ok(Map.of("message", "Email vérifié avec succès"));
        } catch (Exception e) {
            logger.error("Verify email error", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur lors de la vérification"));
        }
    }

    @PostMapping("/resend-verification")
    public ResponseEntity<?> resendVerification(@RequestBody Map<String, String> body) {
        try {
            String email = body.get("email");
            if (email == null) return ResponseEntity.badRequest().body(Map.of("error", "Email requis"));
            boolean ok = authService.resendVerification(email);
            if (!ok) return ResponseEntity.status(404).body(Map.of("error", "Aucun compte trouvé avec cet email ou email déjà vérifié"));
            return ResponseEntity.ok(Map.of("message", "Email de vérification renvoyé"));
        } catch (Exception e) {
            logger.error("Resend verification error", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur"));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@CookieValue(value = "authToken", required = false) String authToken) {
        try {
            if (authToken == null) return ResponseEntity.status(401).body(Map.of("error", "Token d'authentification manquant"));
            var uOpt = authService.validateTokenAndGetUser(authToken);
            if (uOpt.isEmpty()) return ResponseEntity.status(401).body(Map.of("error", "Token invalide"));
            Users u = uOpt.get();
            return ResponseEntity.ok(Map.of("user", Map.of("id", u.getId(), "email", u.getEmail(), "nom", u.getFirstName(), "prenom", u.getLastName())));
        } catch (Exception e) {
            logger.error("Me error", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur"));
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> body) {
        try {
            String email = body.get("email");
            if (email == null) return ResponseEntity.badRequest().body(Map.of("error", "Email requis"));
            authService.createPasswordReset(email);
            return ResponseEntity.ok(Map.of("message", "Si cet email existe, un lien de réinitialisation a été envoyé"));
        } catch (Exception e) {
            logger.error("Forgot password error", e);
            return ResponseEntity.status(500).body(Map.of("error", "Erreur serveur"));
        }
    }
}
