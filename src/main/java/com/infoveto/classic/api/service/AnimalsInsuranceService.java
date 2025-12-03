package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalInsurance;
import com.infoveto.classic.api.repository.AnimalInsuranceRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalsInsuranceService {

    @Resource
    AnimalInsuranceRepository animalInsuranceRepository;

    public List<AnimalInsurance> getAll() {
        return animalInsuranceRepository.findAll();
    }

}
