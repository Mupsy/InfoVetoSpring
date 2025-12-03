package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.VetReviewsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vetReviews")
public class VetReviewsController {

    @Resource
    private VetReviewsService vetReviewsService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(vetReviewsService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
