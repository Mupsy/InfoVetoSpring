package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.FavoriteMedications;
import com.infoveto.classic.api.repository.FavoriteDiseasesRepository;
import com.infoveto.classic.api.repository.FavoriteMedicationsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteMedicationsService {

    @Resource
    private FavoriteMedicationsRepository favoriteMedicationsRepository;

    public List<FavoriteMedications> findAll() {
        return favoriteMedicationsRepository.findAll();
    }
}
