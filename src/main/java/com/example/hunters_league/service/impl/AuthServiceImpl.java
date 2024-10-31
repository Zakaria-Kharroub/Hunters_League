package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.User;
import com.example.hunters_league.repository.AuthRepository;
import com.example.hunters_league.service.AuthService;
import com.example.hunters_league.web.errors.user.IncorrectPasswordException;
import com.example.hunters_league.web.errors.user.UserNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public boolean login(User userLogin) {
        User user = authRepository.findByUsername(userLogin.getUsername())
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        if (BCrypt.checkpw(userLogin.getPassword(), user.getPassword())) {
            return true;
        } else {
            throw new IncorrectPasswordException("Incorrect password");
        }
    }

    @Override
    public User register(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return authRepository.save(user);
    }
}