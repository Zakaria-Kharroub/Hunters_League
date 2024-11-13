package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.Competition;
import com.example.hunters_league.service.CompetitionService;
import com.example.hunters_league.service.dto.CompetitionDTO;
import com.example.hunters_league.web.vm.CompetitionSaveVM;
import com.example.hunters_league.web.vm.mapper.CompetitionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/competition")
public class CompetitionController {

    private final CompetitionService competitionService;
    private final CompetitionMapper competitionMapper;

    public CompetitionController(CompetitionService competitionService, CompetitionMapper competitionMapper) {
        this.competitionMapper = competitionMapper;
        this.competitionService = competitionService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CompetitionDTO> find(@PathVariable String id) {
        Competition competition = competitionService.findById(id);
        CompetitionDTO competitionDTO = competitionMapper.toDTO(competition);
        return ResponseEntity.ok(competitionDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<CompetitionDTO> save(@RequestBody CompetitionSaveVM competitionSaveVM) {
        Competition competition = competitionMapper.toEntity(competitionSaveVM);
        Competition savedCompetition = competitionService.save(competition);
        CompetitionDTO competitionDTO = competitionMapper.toDTO(savedCompetition);
        return new ResponseEntity<>(competitionDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getCompetitionWithParticipationsCount/{id}")
    public ResponseEntity<CompetitionDTO> getCompetitionWithParticipationsCount(@PathVariable UUID id) {
        CompetitionDTO competitionDTO = competitionService.getCompetitionWithParticipationsCount(id);
        return ResponseEntity.ok(competitionDTO);
    }
}