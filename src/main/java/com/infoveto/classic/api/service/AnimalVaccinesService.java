package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalVaccines;
import com.infoveto.classic.api.repository.AnimalVaccinesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalVaccinesService {

    @Resource
    private AnimalVaccinesRepository animalVaccinesRepository;

    public List<AnimalVaccines> findAll(){
        return animalVaccinesRepository.findAll();
    }
}
