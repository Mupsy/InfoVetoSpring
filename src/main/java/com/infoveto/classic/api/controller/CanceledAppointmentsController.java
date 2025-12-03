package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.CanceledAppointmentsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canceledAppointments")
public class CanceledAppointmentsController {

    @Resource
    private CanceledAppointmentsService canceledAppointmentsService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(canceledAppointmentsService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
