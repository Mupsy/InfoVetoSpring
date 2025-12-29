package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.PasswordReset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {
    Optional<PasswordReset> findByToken(String token);
    void deleteByEmail(String email);
    void deleteByToken(String token);
}
