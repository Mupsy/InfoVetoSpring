package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.CalculIA;
import com.infoveto.classic.api.repository.CalculIARepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CalculIAService {

    @Resource
    private CalculIARepository calculIARepository;


}
