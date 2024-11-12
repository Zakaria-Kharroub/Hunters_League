package com.example.hunters_league.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class HuntDTO {
    private UUID id;
    private UUID participationId;
    private UUID speciesId;
    private Double weight;
}