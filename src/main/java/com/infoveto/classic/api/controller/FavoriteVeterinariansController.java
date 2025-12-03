package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.FavoriteVeterinariansService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favoriteVeterinarians")
public class FavoriteVeterinariansController {

    @Resource
    private FavoriteVeterinariansService favoriteVeterinariansService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(favoriteVeterinariansService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
