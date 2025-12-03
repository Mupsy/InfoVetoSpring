package com.infoveto.classic.api.controller;

import com.infoveto.classic.api.service.FavoriteDiseasesService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favoriteDiseases")
public class FavoriteDiseasesController {

    @Resource
    private FavoriteDiseasesService favoriteDiseasesService;

    @GetMapping("")
    public ResponseEntity<?> getAllFavorites() {
        try {
            return ResponseEntity.ok().body(favoriteDiseasesService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
