package com.infoveto.classic.api.service;

import com.infoveto.classic.api.entity.FavoriteDiseases;
import com.infoveto.classic.api.repository.FavoriteDiseasesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteDiseasesService {

    @Resource
    private FavoriteDiseasesRepository favoriteDiseasesRepository;

    public List<FavoriteDiseases> findAll() {
        return favoriteDiseasesRepository.findAll();
    }
}
