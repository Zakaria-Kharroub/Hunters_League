    package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.Species;
import com.example.hunters_league.domain.enums.SpeciesType;
import com.example.hunters_league.service.SpeciesService;
import com.example.hunters_league.service.dto.SpeciesDTO;
import com.example.hunters_league.web.errors.species.SpeciesTypeNotFoundException;
import com.example.hunters_league.web.vm.SpeciesVM;
import com.example.hunters_league.web.vm.mapper.SpeciesMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @GetMapping("/")
    public ResponseEntity<List<SpeciesDTO>> findAll() {
        List<Species> speciesList = speciesService.findAll();
            List<SpeciesDTO> speciesDTOList = speciesList.stream()
                    .map(speciesMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(speciesDTOList);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<SpeciesDTO>> findByCategory(@PathVariable String category) {
        SpeciesType speciesType;
            try {
                speciesType = SpeciesType.valueOf(category);
            } catch (IllegalArgumentException e) {
                throw new SpeciesTypeNotFoundException("Species type not found");
            }
            List<Species> speciesList = speciesService.findByCategory(speciesType);
            List<SpeciesDTO> speciesDTOList = speciesList.stream()
                    .map(speciesMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(speciesDTOList);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<SpeciesDTO>findById(@PathVariable UUID id){
        Species species = speciesService.findById(id.toString());
        SpeciesDTO speciesDTO = speciesMapper.toDTO(species);
        return ResponseEntity.ok(speciesDTO);
    }








}