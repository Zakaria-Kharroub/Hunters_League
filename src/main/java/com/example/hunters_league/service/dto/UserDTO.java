package com.example.hunters_league.service.dto;


import com.example.hunters_league.domain.enums.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String cin;
    private String nationality;
    private Role role;




}
