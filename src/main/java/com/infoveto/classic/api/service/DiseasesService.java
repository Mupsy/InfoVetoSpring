package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.Diseases;
import com.infoveto.classic.api.repository.DiseasesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseasesService {

    @Resource
    private DiseasesRepository diseasesRepository;

    public List<Diseases> findAll() {
        return diseasesRepository.findAll();
    }
}
