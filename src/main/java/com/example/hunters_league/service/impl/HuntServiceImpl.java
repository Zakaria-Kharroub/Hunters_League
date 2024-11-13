package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.Hunt;
import com.example.hunters_league.domain.Participation;
import com.example.hunters_league.domain.Species;
import com.example.hunters_league.repository.HuntRepository;
import com.example.hunters_league.service.HuntService;
import com.example.hunters_league.service.ParticipationService;
import com.example.hunters_league.service.SpeciesService;
import com.example.hunters_league.service.dto.HuntDTO;
import com.example.hunters_league.web.errors.participation.ParticipationNotFoundException;
import com.example.hunters_league.web.errors.species.SpeciesNotFoundException;
import com.example.hunters_league.web.vm.mapper.HuntMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HuntServiceImpl implements HuntService {

    private final HuntRepository huntRepository;
    private final HuntMapper huntMapper;
    private final ParticipationService participationService;
    private final SpeciesService speciesService;
    public HuntServiceImpl(HuntRepository huntRepository, HuntMapper huntMapper, ParticipationService participationService, SpeciesService speciesService) {
        this.huntRepository = huntRepository;
        this.huntMapper = huntMapper;
        this.participationService = participationService;
        this.speciesService = speciesService;
    }

    @Override
    public Hunt save(Hunt hunt) {
       Participation participation = participationService.findById(hunt.getParticipation().getId());
        if (participation == null) {
            throw new ParticipationNotFoundException("Participation not found");
        }
        Species species = speciesService.findById(hunt.getSpecies().getId().toString());
        if (species == null) {
            throw new SpeciesNotFoundException("Species not found");
        }

        Double score = species.getPoints() + (hunt.getWeight() * species.getCategory().getValue() + species.getDifficulty().getValue());
        participation.setScore(participation.getScore()+score);
        participationService.update(participation);
        return huntRepository.save(hunt);
    }

    @Override
    public HuntDTO findById(UUID id) {
        Hunt hunt = huntRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hunt not found"));
        return huntMapper.toDTO(hunt);
    }
}