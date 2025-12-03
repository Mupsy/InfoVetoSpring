package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.Articles;
import com.infoveto.classic.api.repository.ArticlesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {

    @Resource
    private ArticlesRepository articlesRepository;

    public List<Articles> getAll(){
        return articlesRepository.findAll();
    }
}
