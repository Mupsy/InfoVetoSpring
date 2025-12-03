package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.UsersQuestionsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usersQuestions")
public class UsersQuestionsController {

    @Resource
    private UsersQuestionsService usersQuestionsService;


}
