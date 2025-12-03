package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.ArticlesFeedbackService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articlesFeedback")
public class ArticlesFeedbackController {

    @Resource
    private ArticlesFeedbackService articlesFeedbackService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(articlesFeedbackService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
