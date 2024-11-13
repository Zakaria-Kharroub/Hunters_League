package com.example.hunters_league.service;

import com.example.hunters_league.domain.Participation;

import java.util.UUID;

public interface ParticipationService {
    Participation findById(UUID id);
    Participation save(Participation participation);
}