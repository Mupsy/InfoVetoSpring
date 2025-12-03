package com.infoveto.classic.api.service;

import com.infoveto.classic.api.repository.MailConfirmRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MailConfirmService {

    @Resource
    private MailConfirmRepository mailConfirmRepository;
}
