package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.Participation;
import com.example.hunters_league.repository.ParticipationRepository;
import com.example.hunters_league.service.ParticipationService;
import com.example.hunters_league.web.errors.participation.ParticipationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParticipationServiceImpl implements ParticipationService {

    private final ParticipationRepository participationRepository;

    public ParticipationServiceImpl(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    @Override
    public Participation findById(UUID id) {
        return participationRepository.findById(id)
                .orElseThrow(() -> new ParticipationNotFoundException("Participation not found"));
    }

    @Override
    public Participation save(Participation participation) {
        return participationRepository.save(participation);
    }
}