package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.VetRatingService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vetRatings")
public class VetRatingController {

    @Resource
    private VetRatingService vetRatingService;
}
