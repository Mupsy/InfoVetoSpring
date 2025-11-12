package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.Veterinarians;
import com.infoveto.classic.api.repository.VeterainariansRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianService {

    @Resource
    VeterainariansRepository veterainariansRepository;

    public List<Veterinarians> getAll(){
        return veterainariansRepository.findAll();
    }
}
