package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.FavoriteVeterinarians;
import com.infoveto.classic.api.repository.FavoriteVeterinariansRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteVeterinariansService {

    @Resource
    private FavoriteVeterinariansRepository favoriteVeterinariansRepository;

    public List<FavoriteVeterinarians> findAll(){
        return favoriteVeterinariansRepository.findAll();
    }
}
