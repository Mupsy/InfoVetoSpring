package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.FavoriteMedications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteMedicationsRepository extends JpaRepository<FavoriteMedications, Long> {
	long countByUserId_Id(String userId);
	void deleteByUserId_Id(String userId);
	java.util.List<FavoriteMedications> findTop5ByUserId_IdOrderByAddedAtDesc(String userId);
}
