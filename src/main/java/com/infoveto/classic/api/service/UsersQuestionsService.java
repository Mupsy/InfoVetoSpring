package com.infoveto.classic.api.service;

import com.infoveto.classic.api.repository.UsersQuestionsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersQuestionsService {

    @Resource
    private UsersQuestionsRepository usersQuestionsRepository;
}
