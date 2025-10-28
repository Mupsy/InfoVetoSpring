package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.ApiApplication;
import com.infoveto.classic.api.entity.Users;
import com.infoveto.classic.api.service.UsersService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;
    private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @GetMapping("")
    public ResponseEntity<List<Users>> getAllUsers() {
        try{
            logger.info("[Users Controller] Get all users");
            return ResponseEntity.ok().body(usersService.getUsers());
        }catch(Exception e){
            logger.error("[Users Controller] Get all users failed", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
