package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    // Users.id in this project is a String UUID. JpaRepository already exposes
    // Optional<Users> findById(...) so we add common lookup by email.
    java.util.Optional<Users> findByEmail(String email);
}
