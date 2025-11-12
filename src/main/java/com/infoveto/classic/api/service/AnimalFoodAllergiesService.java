package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalFoodAllergies;
import com.infoveto.classic.api.repository.AnimalFoodAllergiesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalFoodAllergiesService {

    @Resource
    private AnimalFoodAllergiesRepository animalFoodAllergiesRepository;

    public List<AnimalFoodAllergies> getAll() {
        return animalFoodAllergiesRepository.findAll();
    }
}
