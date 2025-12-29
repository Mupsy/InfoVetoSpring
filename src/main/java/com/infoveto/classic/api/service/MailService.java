package com.infoveto.classic.api.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender mailSender;

    @Value("${app.mail.smtp.enabled:false}")
    private boolean smtpEnabled;

    @Value("${app.mail.from:infoveto@gmail.com}")
    private String fromAddress;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean send(String to, String subject, String html) {
        if (!smtpEnabled) {
            logger.info("[MAIL SIMULATION] From: {} To: {} Subject: {}", fromAddress, to, subject);
            logger.debug("HTML: {}", html);
            return true;
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setFrom(fromAddress);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);
            mailSender.send(message);
            logger.info("[MAIL] Sent to {} subject {}", to, subject);
            return true;
        } catch (MessagingException | RuntimeException ex) {
            logger.error("[MAIL] Error sending email to {}: {}", to, ex.getMessage(), ex);
            return false;
        }
    }
}
