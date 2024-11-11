package com.example.hunters_league.web.errors.species;

public class SpeciesTypeNotFoundException extends RuntimeException {
    public SpeciesTypeNotFoundException(String message) {
        super(message);
    }
}