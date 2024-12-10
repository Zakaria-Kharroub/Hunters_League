package com.example.hunters_league.service;

import com.example.hunters_league.domain.AppUser;

public interface AuthService {
    boolean login(AppUser appUserLogin);
    AppUser register(AppUser appUser);
}