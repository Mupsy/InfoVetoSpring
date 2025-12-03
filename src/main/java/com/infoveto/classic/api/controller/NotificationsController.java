package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.NotificationsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @Resource
    private NotificationsService notificationsService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(notificationsService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
