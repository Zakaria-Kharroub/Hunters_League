    package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.Species;
import com.example.hunters_league.service.SpeciesService;
import com.example.hunters_league.service.dto.SpeciesDTO;
import com.example.hunters_league.web.errors.species.SpeciesTypeNotFoundException;
import com.example.hunters_league.web.vm.SpeciesVM;
import com.example.hunters_league.web.vm.mapper.SpeciesMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    private final SpeciesService speciesService;
    private final SpeciesMapper speciesMapper;

    public SpeciesController(SpeciesService speciesService, SpeciesMapper speciesMapper) {
        this.speciesService = speciesService;
        this.speciesMapper = speciesMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<SpeciesDTO> save(@RequestBody SpeciesVM speciesVM) {
//        if (speciesVM.getCategory() == null) {
//            throw new SpeciesTypeNotFoundException("Species type not found");
//        }

        Species species = speciesMapper.toEntity(speciesVM);
        Species savedSpecies = speciesService.save(species);
        SpeciesDTO speciesDTO = speciesMapper.toDTO(savedSpecies);
        return new ResponseEntity<>(speciesDTO, HttpStatus.CREATED);
    }
}