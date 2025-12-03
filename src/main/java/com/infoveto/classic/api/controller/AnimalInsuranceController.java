package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.AnimalsInsuranceService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalsInsurance")
public class AnimalInsuranceController {

    @Resource
    private AnimalsInsuranceService animalsInsuranceService;

    public ResponseEntity<?> findAll() {
        try{
            return ResponseEntity.ok().body(animalsInsuranceService.getAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
