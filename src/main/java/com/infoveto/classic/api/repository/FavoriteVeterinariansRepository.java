package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.FavoriteVeterinarians;
import com.infoveto.classic.api.entity.Veterinarians;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteVeterinariansRepository extends JpaRepository<FavoriteVeterinarians, Long> {
	long countByUserId_Id(String userId);
	void deleteByUserId_Id(String userId);
	java.util.List<FavoriteVeterinarians> findTop5ByUserId_IdOrderByAddedAtDesc(String userId);

}
