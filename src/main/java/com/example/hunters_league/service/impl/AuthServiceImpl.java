package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.AppUser;
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
    public boolean login(AppUser appUserLogin) {
        AppUser appUser = authRepository.findByUsername(appUserLogin.getUsername())
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        if (BCrypt.checkpw(appUserLogin.getPassword(), appUser.getPassword())) {
            return true;
        } else {
            throw new IncorrectPasswordException("Incorrect password");
        }
    }

    @Override
    public AppUser register(AppUser appUser) {
        String hashedPassword = BCrypt.hashpw(appUser.getPassword(), BCrypt.gensalt());
        appUser.setPassword(hashedPassword);
        return authRepository.save(appUser);
    }
}