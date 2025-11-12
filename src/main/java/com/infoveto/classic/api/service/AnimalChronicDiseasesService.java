package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalChronicDiseases;
import com.infoveto.classic.api.repository.AnimalChronicDiseasesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalChronicDiseasesService {

    @Resource
    AnimalChronicDiseasesRepository animalChronicDiseasesRepository;

    public List<AnimalChronicDiseases> getAll(){
        return animalChronicDiseasesRepository.findAll();
    }
}
