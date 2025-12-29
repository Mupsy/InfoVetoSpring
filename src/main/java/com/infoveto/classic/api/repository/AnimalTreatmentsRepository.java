package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.AnimalTreatments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTreatmentsRepository extends JpaRepository<AnimalTreatments, Long> {
	void deleteByAnimal_UserId_Id(String userId);
}
