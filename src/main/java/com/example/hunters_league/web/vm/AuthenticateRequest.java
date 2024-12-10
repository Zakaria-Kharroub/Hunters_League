package com.example.hunters_league.web.vm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateRequest {
    private String email;
    private String password;
}