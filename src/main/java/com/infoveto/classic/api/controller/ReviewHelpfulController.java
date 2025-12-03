package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.ReviewHelpfulService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviewHelpful")
public class ReviewHelpfulController {

    @Resource
    private ReviewHelpfulService reviewHelpfulService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(reviewHelpfulService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
