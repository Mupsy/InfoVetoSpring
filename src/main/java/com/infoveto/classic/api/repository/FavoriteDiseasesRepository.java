package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.FavoriteDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDiseasesRepository extends JpaRepository<FavoriteDiseases, Long> {
	long countByUserId_Id(String userId);
	void deleteByUserId_Id(String userId);
	java.util.List<FavoriteDiseases> findTop5ByUserId_IdOrderByAddedAtDesc(String userId);
}
