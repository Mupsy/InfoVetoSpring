package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.VetRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRatingRepository extends JpaRepository<VetRating, Long> {
}
