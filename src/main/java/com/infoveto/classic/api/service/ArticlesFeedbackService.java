package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.ArticlesFeedback;
import com.infoveto.classic.api.repository.ArticlesFeedbackRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesFeedbackService {

    @Resource
    private ArticlesFeedbackRepository articlesFeedbackRepository;

    public List<ArticlesFeedback> findAll(){
        return articlesFeedbackRepository.findAll();
    }
}
