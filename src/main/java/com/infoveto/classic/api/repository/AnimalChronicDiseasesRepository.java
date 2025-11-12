package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.AnimalChronicDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalChronicDiseasesRepository extends JpaRepository<AnimalChronicDiseases, Long> {
}
