package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.AnimalFoodAllergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalFoodAllergiesRepository extends JpaRepository<AnimalFoodAllergies, Long> {
}
