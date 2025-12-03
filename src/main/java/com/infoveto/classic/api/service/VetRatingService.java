package com.infoveto.classic.api.service;

import com.infoveto.classic.api.repository.VetRatingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class VetRatingService {

    @Resource
    private VetRatingRepository vetRatingRepository;
}
