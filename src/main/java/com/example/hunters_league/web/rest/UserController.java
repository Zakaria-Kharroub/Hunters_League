package com.example.hunters_league.web.rest;

import com.example.hunters_league.service.UserService;
import com.example.hunters_league.web.vm.UserDeleteVM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserDeleteVM userDeleteVM) {
        boolean isDeleted = userService.delete(userDeleteVM.getUsername());
        if (isDeleted) {
            return ResponseEntity.ok("User deleted");
        } else {
            return ResponseEntity.ok("User not found");
        }
    }
}