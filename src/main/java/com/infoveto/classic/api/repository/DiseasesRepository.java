package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.Diseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseasesRepository extends JpaRepository<Diseases, Long> {
}
