package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.Species;
import com.example.hunters_league.domain.enums.SpeciesType;
import com.example.hunters_league.repository.SpeciesRepository;
import com.example.hunters_league.service.SpeciesService;
import com.example.hunters_league.web.errors.species.SpeciesTypeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<Species> findAll(){
        return speciesRepository.findAll();
    }

    @Override
    public List<Species> findByCategory(SpeciesType category){
        return speciesRepository.findByCategory(category);
    }

    @Override
    public Species updateById(UUID id, Species species) {
        Species existingSpecies = speciesRepository.findById(id)

                .orElseThrow(() -> new SpeciesTypeNotFoundException("specis not found"));

        existingSpecies.setName(species.getName());
        existingSpecies.setCategory(species.getCategory());
        existingSpecies.setMinimumWeight(species.getMinimumWeight());
        existingSpecies.setDifficulty(species.getDifficulty());
        existingSpecies.setPoints(species.getPoints());
        return speciesRepository.save(existingSpecies);

    }



}