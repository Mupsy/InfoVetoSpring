package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.Animals;
import com.infoveto.classic.api.repository.AnimalsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalsService {

    @Resource
    private AnimalsRepository animalsRepository;

    public List<Animals> getAllAnimals() {
        return animalsRepository.findAll();
    }
}
