package com.example.hunters_league.web.errors.competition;

public class CompetitionNotFoundException extends RuntimeException {
    public CompetitionNotFoundException(String message) {
        super(message);
    }
}
