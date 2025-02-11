package com.example.hunters_league.service;

import com.example.hunters_league.domain.Species;
import com.example.hunters_league.domain.enums.SpeciesType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SpeciesService {
    Species findById(String id);
    Species save(Species species);
    List<Species> findAll();
    List<Species> findByCategory(SpeciesType category);
    Species updateById(UUID id, Species species);

    Page<Species> findAll(Pageable pageable);





}