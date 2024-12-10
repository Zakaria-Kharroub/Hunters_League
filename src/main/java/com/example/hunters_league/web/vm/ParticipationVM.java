package com.example.hunters_league.web.vm;

import lombok.Data;

import java.util.UUID;

@Data
public class ParticipationVM {
    private UUID userId;
    private UUID competitionId;
    private Double score;

}