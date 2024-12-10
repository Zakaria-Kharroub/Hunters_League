package com.example.hunters_league.web.errors.species;

public class SpeciesNotFoundException extends RuntimeException {
    public SpeciesNotFoundException(String message) {
        super(message);
    }
}
