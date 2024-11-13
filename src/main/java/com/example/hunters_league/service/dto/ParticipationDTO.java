package com.example.hunters_league.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ParticipationDTO {
    private UUID id;
    private UUID userId;
    private UUID competitionId;
    private Double score;
}