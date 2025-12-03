package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.VetReviews;
import com.infoveto.classic.api.repository.VetReviewsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetReviewsService {

    @Resource
    private VetReviewsRepository vetReviewsRepository;

    public List<VetReviews> findAll(){
        return vetReviewsRepository.findAll();
    }
}
