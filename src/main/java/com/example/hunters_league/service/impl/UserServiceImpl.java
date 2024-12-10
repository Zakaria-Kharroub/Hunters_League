package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.AppUser;
import com.example.hunters_league.repository.UserRepository;
import com.example.hunters_league.service.UserService;
import com.example.hunters_league.web.errors.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean delete(String username) {
        AppUser appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        userRepository.delete(appUser);
        return true;
    }

    @Override
    public AppUser findById(String id) {
        return userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    @Override
    public AppUser findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
    }



}