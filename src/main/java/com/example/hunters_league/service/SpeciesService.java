package com.example.hunters_league.service;

import com.example.hunters_league.domain.Species;
import com.example.hunters_league.domain.enums.SpeciesType;

import java.util.List;

public interface SpeciesService {
    Species findById(String id);
    Species save(Species species);
    List<Species> findAll();
    List<Species> findByCategory(SpeciesType category);

}