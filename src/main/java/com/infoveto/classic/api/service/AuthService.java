package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.MailConfirm;
import com.infoveto.classic.api.entity.PasswordReset;
import com.infoveto.classic.api.entity.Users;
import com.infoveto.classic.api.repository.MailConfirmRepository;
import com.infoveto.classic.api.repository.PasswordResetRepository;
import com.infoveto.classic.api.repository.UserRepository;
import com.infoveto.classic.api.util.JwtUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final MailConfirmRepository mailConfirmRepository;
    private final PasswordResetRepository passwordResetRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final MailService mailService;

    public AuthService(UserRepository userRepository,
                       MailConfirmRepository mailConfirmRepository,
                       PasswordResetRepository passwordResetRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil,
                       MailService mailService) {
        this.userRepository = userRepository;
        this.mailConfirmRepository = mailConfirmRepository;
        this.passwordResetRepository = passwordResetRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.mailService = mailService;
    }

    @Transactional
    public Users registerUser(Users u) {
        // hash password
        if (u.getPassword() != null) u.setPassword(passwordEncoder.encode(u.getPassword()));
        // persist
        // persist and flush so generated id (if any) is available and entity is managed
        Users saved = userRepository.saveAndFlush(u);

        // create verification token
        String token = UUID.randomUUID().toString().replace("-", "") + Long.toHexString(new Date().getTime());
        MailConfirm mc = MailConfirm.builder().userId(saved).token(token).build();
        mailConfirmRepository.save(mc);

        // send email (simulated)
        String verificationUrl = "http://localhost:3000/verification-email?token=" + token;
        String html = "<p>Verify your email: " + verificationUrl + "</p>";
        mailService.send(saved.getEmail(), "Vérifiez votre email - InfoVéto", html);

        return saved;
    }

    public Optional<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String generateTokenForUser(Users user) {
        return jwtUtil.generateToken(user.getId(), user.getEmail());
    }

    public boolean verifyEmailToken(String token) {
        Optional<MailConfirm> mcOpt = mailConfirmRepository.findByToken(token);
        if (mcOpt.isEmpty()) return false;
        MailConfirm mc = mcOpt.get();
        // check age - MailConfirm.createdAt is stored as String or Date; entity uses String in repo, but builder uses DB timestamp. Attempt to update user's verified flag
        Users u = mc.getUserId();
        if (u == null) return false;
        u.setEmailVerified(true);
        u.setEmailVerifiedAt(new Date());
        userRepository.save(u);
        mailConfirmRepository.delete(mc);
        return true;
    }

    public boolean resendVerification(String email) {
        Optional<Users> uOpt = userRepository.findByEmail(email);
        if (uOpt.isEmpty()) return false;
        Users u = uOpt.get();
        if (u.isEmailVerified()) return false;

        mailConfirmRepository.deleteByUserId_Id(u.getId());
        String token = UUID.randomUUID().toString().replace("-", "") + Long.toHexString(new Date().getTime());
        MailConfirm mc = MailConfirm.builder().userId(u).token(token).build();
        mailConfirmRepository.save(mc);

        String verificationUrl = "http://localhost:3000/verification-email?token=" + token;
        String html = "<p>Verify your email: " + verificationUrl + "</p>";
        mailService.send(email, "Vérifiez votre email - InfoVéto", html);
        return true;
    }

    public boolean createPasswordReset(String email) {
        Optional<Users> uOpt = userRepository.findByEmail(email);
        if (uOpt.isEmpty()) return false;

        String token = UUID.randomUUID().toString().replace("-", "") + Long.toHexString(new Date().getTime());
        passwordResetRepository.deleteByEmail(email);
        PasswordReset pr = PasswordReset.builder().email(email).token(token).build();
        passwordResetRepository.save(pr);

        String resetUrl = "http://localhost:3000/reset-password?token=" + token;
        String html = "<p>Reset your password: " + resetUrl + "</p>";
        mailService.send(email, "Réinitialisation de mot de passe - InfoVéto", html);
        return true;
    }

    public java.util.Optional<Users> validateTokenAndGetUser(String token) {
        try {
            var claims = jwtUtil.validateToken(token);
            String userId = claims.getSubject();
            return userRepository.findById(userId);
        } catch (Exception e) {
            logger.debug("Invalid token", e);
            return java.util.Optional.empty();
        }
    }

}
