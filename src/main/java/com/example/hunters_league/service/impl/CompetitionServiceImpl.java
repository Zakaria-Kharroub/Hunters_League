package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.Competition;
import com.example.hunters_league.repository.CompetitionRepository;
import com.example.hunters_league.service.CompetitionService;
import com.example.hunters_league.web.errors.competition.CompetitionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public Competition findById(String id) {
        return competitionRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new CompetitionNotFoundException("Competition not found"));
    }
}