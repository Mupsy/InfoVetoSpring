package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
	long countByUserId_IdAndIsReadFalse(String userId);
	void deleteByUserId_Id(String userId);
	java.util.List<Notifications> findTop5ByUserId_IdOrderByCreatedAtDesc(String userId);
}
