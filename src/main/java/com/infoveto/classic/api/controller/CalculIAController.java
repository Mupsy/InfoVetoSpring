package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.CalculIAService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculIA")
public class CalculIAController {

    @Resource
    private CalculIAService calculIAService;
}
