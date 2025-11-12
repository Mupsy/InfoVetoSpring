package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.AnimalDocuments;
import com.infoveto.classic.api.repository.AnimalDocumentsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalDocumentsService {

    @Resource
    private AnimalDocumentsRepository animalDocumentsRepository;

    public List<AnimalDocuments> findAll() {
        return animalDocumentsRepository.findAll();
    }
}
