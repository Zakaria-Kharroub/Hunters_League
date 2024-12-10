package com.example.hunters_league.service.dto;

import lombok.*;

import java.time.LocalDateTime;


public class CompetitionDTO {
    private String code;
    private String location;
    private LocalDateTime date;
    private Long nbParticipation;

    public CompetitionDTO(String code, String location, LocalDateTime date, Long nbParticipation) {
        this.code = code;
        this.location = location;
        this.date = date;
        this.nbParticipation = nbParticipation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getNbParticipation() {
        return nbParticipation;
    }

    public void setNbParticipation(Long nbParticipation) {
        this.nbParticipation = nbParticipation;
    }
}