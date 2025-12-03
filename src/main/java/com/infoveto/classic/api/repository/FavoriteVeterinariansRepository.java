package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.FavoriteVeterinarians;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteVeterinariansRepository extends JpaRepository<FavoriteVeterinarians, Long> {
}
