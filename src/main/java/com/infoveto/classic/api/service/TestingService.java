package com.infoveto.classic.api.service;

import com.infoveto.classic.api.ApiApplication;
import com.infoveto.classic.api.entity.TestingEntity;
import com.infoveto.classic.api.repository.TestingRepository;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestingService {

    private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);
    @Resource
    private TestingRepository repository;

    public List<TestingEntity> findAllByUsername(String username) {
        logger.info("findAllByUsername: " + username);
        return repository.findAllByUserNameIgnoreCase(username);
    }

    public List<TestingEntity> findAll() {
        logger.info("findAll : " + repository.findAll());
        return repository.findAll();
    }

    public List<TestingEntity> findAllByUserMail(String userMail) {
        logger.info("findAllByUserMail: " + userMail);
        return repository.findAllByUserMail(userMail).stream().distinct().collect(Collectors.toList());
    }

}
