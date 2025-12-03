package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.AnimalsSurgeriesService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalsSurgeries")
public class AnimalSurgeriesController {

    @Resource
    private AnimalsSurgeriesService animalsSurgeriesService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(animalsSurgeriesService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
