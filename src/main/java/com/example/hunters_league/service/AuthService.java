package com.example.hunters_league.service;

import com.example.hunters_league.domain.User;

public interface AuthService {
    boolean login(User userLogin);
    User register(User user);
}