package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.Competition;
import com.example.hunters_league.domain.Participation;
import com.example.hunters_league.domain.User;
import com.example.hunters_league.repository.ParticipationRepository;
import com.example.hunters_league.service.CompetitionService;
import com.example.hunters_league.service.ParticipationService;
import com.example.hunters_league.service.UserService;
import com.example.hunters_league.web.errors.competition.CompetitionNotFoundException;
import com.example.hunters_league.web.errors.participation.ParticipationNotFoundException;
import com.example.hunters_league.web.errors.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParticipationServiceImpl implements ParticipationService {

    private final ParticipationRepository participationRepository;
    private final UserService userService;
    private final CompetitionService competitionService;

    public ParticipationServiceImpl(ParticipationRepository participationRepository, UserService userService,CompetitionService competitionService) {
        this.participationRepository = participationRepository;
        this.userService = userService;
        this.competitionService= competitionService;
    }

    @Override
    public Participation findById(UUID id) {
        return participationRepository.findById(id)
                .orElseThrow(() -> new ParticipationNotFoundException("Participation not found"));
    }

    @Override
    public Participation save(Participation participation) {

        User user = userService.findById(participation.getUser().getId().toString());
        if (user == null) {
            throw new UserNotFoundException("user not found");
        }

        Competition competition = competitionService.findById(participation.getCompetition().getId().toString());
        if (competition == null) {
            throw new CompetitionNotFoundException("competition not found");
        }


        return participationRepository.save(participation);
    }

    @Override
    public Participation update(Participation participation) {
        return participationRepository.save(participation);
    }
}