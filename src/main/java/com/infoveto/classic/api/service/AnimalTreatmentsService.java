package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalTreatments;
import com.infoveto.classic.api.repository.AnimalTreatmentsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalTreatmentsService {

    @Resource
    private AnimalTreatmentsRepository animalTreatmentsRepository;

    public List<AnimalTreatments> findAll() {
        return animalTreatmentsRepository.findAll();
    }
}

