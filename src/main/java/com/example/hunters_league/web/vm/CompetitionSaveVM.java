package com.example.hunters_league.web.vm;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompetitionSaveVM {
    private String code;
    private String location;
    private LocalDateTime date;
    private String speciesType;
    private Integer minParticipants;
    private Integer maxParticipants;
    private Boolean openRegistration;
}