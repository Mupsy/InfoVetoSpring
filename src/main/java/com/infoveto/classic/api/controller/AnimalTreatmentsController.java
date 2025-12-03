package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.AnimalTreatmentsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalTreatments")
public class AnimalTreatmentsController {

    @Resource
    private AnimalTreatmentsService animalTreatmentsService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(animalTreatmentsService.findAll());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
