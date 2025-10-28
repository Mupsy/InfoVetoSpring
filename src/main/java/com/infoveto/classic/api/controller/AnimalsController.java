package com.infoveto.classic.api.controller;


import com.infoveto.classic.api.entity.Animals;
import com.infoveto.classic.api.service.AnimalsService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    @Resource
    private AnimalsService animalsService;

    @GetMapping("")
    public ResponseEntity<List<Animals>> getAllAnimals() {
        try{
            return ResponseEntity.ok().body(animalsService.getAllAnimals());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
