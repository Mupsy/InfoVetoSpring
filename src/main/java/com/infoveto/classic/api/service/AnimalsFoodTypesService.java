package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalFoodTypes;
import com.infoveto.classic.api.repository.AnimalsFoodTypesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalsFoodTypesService {

    @Resource
    private AnimalsFoodTypesRepository animalsFoodTypesRepository;

    public List<AnimalFoodTypes> findAll(){
        return animalsFoodTypesRepository.findAll();
    }

}
