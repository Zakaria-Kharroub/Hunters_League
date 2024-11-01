package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.Competition;
import com.example.hunters_league.service.CompetitionService;
import com.example.hunters_league.service.dto.CompetitionDTO;
import com.example.hunters_league.web.vm.mapper.CompetitionMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}