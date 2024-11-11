package com.example.hunters_league.service;

import com.example.hunters_league.domain.Species;

public interface SpeciesService {
    Species findById(String id);
    Species save(Species species);
}