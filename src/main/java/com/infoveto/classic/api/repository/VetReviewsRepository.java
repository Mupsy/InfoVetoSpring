package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.VetReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetReviewsRepository extends JpaRepository<VetReviews, Long> {

}
