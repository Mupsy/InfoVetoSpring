package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalAllergies;
import com.infoveto.classic.api.repository.AnimalAllergiesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalsAllergiesService {

    @Resource
    AnimalAllergiesRepository animalAllergiesRepository;

    public List<AnimalAllergies> getAll() {
        return animalAllergiesRepository.findAll();
    }
}
