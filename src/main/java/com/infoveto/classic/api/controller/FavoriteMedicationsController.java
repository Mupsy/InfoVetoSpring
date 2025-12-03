package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.FavoriteMedicationsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favoriteMedications")
public class FavoriteMedicationsController {

    @Resource
    private FavoriteMedicationsService favoriteMedicationsService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(favoriteMedicationsService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
