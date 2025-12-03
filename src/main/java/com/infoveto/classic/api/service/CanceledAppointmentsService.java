package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.CanceledAppointments;
import com.infoveto.classic.api.repository.CanceledAppointmentsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanceledAppointmentsService {

    @Resource
    private CanceledAppointmentsRepository canceledAppointmentsRepository;

    public List<CanceledAppointments> findAll(){
        return canceledAppointmentsRepository.findAll();
    }
}
