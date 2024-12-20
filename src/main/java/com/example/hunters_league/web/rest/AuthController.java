package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.AppUser;
import com.example.hunters_league.service.AuthService;
import com.example.hunters_league.service.dto.UserDTO;
import com.example.hunters_league.web.vm.UserLoginVM;
import com.example.hunters_league.web.vm.UserRegisterVM;
import com.example.hunters_league.web.vm.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class AuthController {


    private final UserMapper userMapper;
    private final AuthService authService;


    public AuthController(UserMapper userMapper, AuthService authService) {
        this.userMapper = userMapper;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginVM userLoginVM) {

        AppUser appUser = userMapper.toEntity(userLoginVM);
        boolean islogedIn = authService.login(appUser);
        if(islogedIn) {
            return ResponseEntity.ok("Login Success");
        } else {
            return  ResponseEntity.ok("Login faild");
        }

    }
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserRegisterVM userRegisterVM) {

        AppUser appUser = userMapper.toEntity(userRegisterVM);
        AppUser savedAppUser = authService.register(appUser);
        UserDTO userDTO = userMapper.toDTO(savedAppUser);
        return new ResponseEntity<>(userDTO , HttpStatus.CREATED);

    }

}
