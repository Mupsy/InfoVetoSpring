package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.MailConfirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailConfirmRepository extends JpaRepository<MailConfirm, Long> {
}
