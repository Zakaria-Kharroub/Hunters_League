package com.example.hunters_league.service;

import com.example.hunters_league.domain.Competition;
import com.example.hunters_league.service.dto.CompetitionDTO;

import java.util.UUID;

public interface CompetitionService {
    Competition findById(String id);
    Competition save(Competition competition);

    CompetitionDTO getCompetitionWithParticipationsCount(UUID id);

}