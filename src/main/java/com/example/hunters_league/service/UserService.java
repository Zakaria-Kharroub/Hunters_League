package com.example.hunters_league.service;

import com.example.hunters_league.domain.AppUser;

public interface UserService {
    boolean delete(String username);
    AppUser findById(String username);
    AppUser findByEmail(String email);

}

