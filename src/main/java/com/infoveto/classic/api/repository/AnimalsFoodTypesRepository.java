package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.AnimalFoodTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsFoodTypesRepository extends JpaRepository<AnimalFoodTypes, Long> {


}
