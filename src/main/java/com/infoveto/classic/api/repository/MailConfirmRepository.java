package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.MailConfirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MailConfirmRepository extends JpaRepository<MailConfirm, Long> {
	void deleteByUserId_Id(String userId);

	Optional<MailConfirm> findByToken(String token);

	void deleteByToken(String token);
}
