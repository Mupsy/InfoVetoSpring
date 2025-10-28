package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {
}
