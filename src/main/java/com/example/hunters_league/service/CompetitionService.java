package com.example.hunters_league.service;

import com.example.hunters_league.domain.Competition;

public interface CompetitionService {
    Competition findById(String id);
    Competition save(Competition competition);

}