package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.Species;
import com.example.hunters_league.repository.SpeciesRepository;
import com.example.hunters_league.service.SpeciesService;
import com.example.hunters_league.web.errors.species.SpeciesTypeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepository;

    public SpeciesServiceImpl(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    public Species findById(String id) {
        return speciesRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new SpeciesTypeNotFoundException("Species not found"));
    }

    @Override
    public Species save(Species species) {
        if (species.getCategory() == null) {
            throw new SpeciesTypeNotFoundException("Species type not found");
        }
        return speciesRepository.save(species);
    }
}