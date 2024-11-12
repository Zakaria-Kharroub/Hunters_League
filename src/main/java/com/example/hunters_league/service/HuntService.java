package com.example.hunters_league.service;

import com.example.hunters_league.domain.Hunt;
import com.example.hunters_league.service.dto.HuntDTO;

import java.util.UUID;

public interface HuntService {
    Hunt save(Hunt hunt);
    HuntDTO findById(UUID id);
}