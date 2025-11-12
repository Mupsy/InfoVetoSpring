package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.VeterinarianService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veterinarians")
public class VeterinariansController {

    @Resource
    VeterinarianService veterinarianService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        try{
            return ResponseEntity.ok().body(veterinarianService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
