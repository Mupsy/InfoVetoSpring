package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.ReviewHelpful;
import com.infoveto.classic.api.repository.ReviewHelpfulRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewHelpfulService {

    @Resource
    private ReviewHelpfulRepository reviewHelpfulRepository;

    public List<ReviewHelpful> findAll() {
        return reviewHelpfulRepository.findAll();
    }
}
