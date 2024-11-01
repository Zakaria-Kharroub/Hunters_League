package com.example.hunters_league.service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CompetitionDTO {
    private String code;
    private String location;
    private LocalDateTime date;
}