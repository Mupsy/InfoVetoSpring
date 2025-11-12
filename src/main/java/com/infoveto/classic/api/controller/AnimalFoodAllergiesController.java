package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.entity.AnimalFoodAllergies;
import com.infoveto.classic.api.service.AnimalFoodAllergiesService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animalsFoodAllergies")
public class AnimalFoodAllergiesController {

    @Resource
    private AnimalFoodAllergiesService animalFoodAllergiesService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.ok().body(animalFoodAllergiesService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
