package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.User;
import com.example.hunters_league.repository.UserRepository;
import com.example.hunters_league.service.UserService;
import com.example.hunters_league.web.errors.user.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean delete(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        userRepository.delete(user);
        return true;
    }

}