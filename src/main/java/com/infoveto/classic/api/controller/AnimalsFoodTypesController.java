package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.AnimalsFoodTypesService;
import jakarta.annotation.Resource;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalsFoodTypes")
public class AnimalsFoodTypesController {

    @Resource
    private AnimalsFoodTypesService animalsFoodTypesService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        try{
            return ResponseEntity.ok().body(animalsFoodTypesService.findAll());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
