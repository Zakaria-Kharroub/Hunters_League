package com.example.hunters_league.web.vm;


import com.example.hunters_league.domain.enums.Role;
import lombok.Data;

@Data
public class UserRegisterVM {


    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String cin;

    private String nationality;

    private Role role;




}
