package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.MedicationsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medications")
public class MedicationsController {

    @Resource
    private MedicationsService medicationsService;

    @GetMapping("")
    public ResponseEntity findAll(){
        try{
            return ResponseEntity.ok().body(medicationsService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
