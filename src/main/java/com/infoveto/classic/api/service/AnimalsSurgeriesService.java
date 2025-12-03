package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalSurgeries;
import com.infoveto.classic.api.repository.AnimalsSurgeriesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalsSurgeriesService {

    @Resource
    AnimalsSurgeriesRepository animalsSurgeriesRepository;

    public List<AnimalSurgeries> findAll(){
        return animalsSurgeriesRepository.findAll();
    }
}
