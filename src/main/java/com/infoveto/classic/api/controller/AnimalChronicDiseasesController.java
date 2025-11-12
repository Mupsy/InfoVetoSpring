package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.entity.AnimalAllergies;
import com.infoveto.classic.api.service.AnimalChronicDiseasesService;
import com.infoveto.classic.api.service.AnimalsAllergiesService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animalsChronicDiseases")
public class AnimalChronicDiseasesController {

    @Resource
    AnimalChronicDiseasesService animalChronicDiseasesService;


    @GetMapping("")
    public ResponseEntity<?> getAllAnimalAllergies() {
        try{
            return ResponseEntity.ok().body(animalChronicDiseasesService.getAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
