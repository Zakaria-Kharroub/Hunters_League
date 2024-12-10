package com.example.hunters_league.service.dto;

import com.example.hunters_league.domain.enums.Difficulty;
import com.example.hunters_league.domain.enums.SpeciesType;
import lombok.Data;

@Data
public class SpeciesDTO {
    private String name;
    private SpeciesType category;
    private Double minimumWeight;
    private Difficulty difficulty;
    private Integer points;
}