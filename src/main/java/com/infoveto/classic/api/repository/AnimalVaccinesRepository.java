package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.AnimalVaccines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalVaccinesRepository extends JpaRepository<AnimalVaccines, Long> {
}
