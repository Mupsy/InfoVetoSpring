package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.AnimalSurgeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsSurgeriesRepository extends JpaRepository<AnimalSurgeries, Long> {

}
