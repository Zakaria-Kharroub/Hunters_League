package com.example.hunters_league.service.imp;

import com.example.hunters_league.domain.User;
import com.example.hunters_league.repository.AuthRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean login (User userLogin){
        User user = authRepository.findByUsername(userLogin.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(user.getPassword().equals(userLogin.getPassword())){
            return true;
        } else {
            throw new IllegalArgumentException("Password is incorrect");
        }

    }

    public User register(User user){
        return authRepository.save(user);
    }


}
