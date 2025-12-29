package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.AnimalDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDocumentsRepository extends JpaRepository<AnimalDocuments, Long> {
	long countByUser_Id(String userId);
	void deleteByUser_Id(String userId);
}
