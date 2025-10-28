package com.infoveto.classic.api.service;

import com.infoveto.classic.api.ApiApplication;
import com.infoveto.classic.api.entity.Users;
import com.infoveto.classic.api.repository.UserRepository;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @Resource
    private UserRepository userRepository;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }
}
