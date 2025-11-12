package com.infoveto.classic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infoveto.classic.api.entity.AnimalAllergies;
@Repository
public interface AnimalAllergiesRepository extends JpaRepository<AnimalAllergies, Long> {
}
