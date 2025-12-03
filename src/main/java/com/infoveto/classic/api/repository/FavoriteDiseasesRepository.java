package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.FavoriteDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDiseasesRepository extends JpaRepository<FavoriteDiseases, Long> {
}
