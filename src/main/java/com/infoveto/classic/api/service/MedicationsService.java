package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.Medication;
import com.infoveto.classic.api.repository.MedicationsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationsService {

    @Resource
    private MedicationsRepository medicationsRepository;

    public List<Medication> findAll(){
        return medicationsRepository.findAll();
    }
}
