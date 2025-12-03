package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.Notifications;
import com.infoveto.classic.api.repository.NotificationsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

    @Resource
    private NotificationsRepository notificationsRepository;

    public List<Notifications> findAll() {
        return notificationsRepository.findAll();
    }
}
