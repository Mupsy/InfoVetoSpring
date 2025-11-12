package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.AnimalDocumentsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalDocuments")
public class AnimalDocumentsController {

    @Resource
    private AnimalDocumentsService animalDocumentsService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(animalDocumentsService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
