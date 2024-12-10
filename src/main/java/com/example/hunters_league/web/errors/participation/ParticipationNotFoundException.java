package com.example.hunters_league.web.errors.participation;

public class ParticipationNotFoundException extends RuntimeException {
    public ParticipationNotFoundException(String message) {
        super(message);
    }
}