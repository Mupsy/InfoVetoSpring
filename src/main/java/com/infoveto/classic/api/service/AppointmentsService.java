package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.Appointments;
import com.infoveto.classic.api.repository.AppointmentsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {

    @Resource
    private AppointmentsRepository appointmentsRepository;

    public List<Appointments> findAll(){
        return appointmentsRepository.findAll();
    }
}
