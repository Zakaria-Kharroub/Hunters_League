package com.example.hunters_league.service;

import com.example.hunters_league.domain.User;

public interface UserService {
    boolean delete(String username);
    User findById(String username);
    User findByEmail(String email);

}

