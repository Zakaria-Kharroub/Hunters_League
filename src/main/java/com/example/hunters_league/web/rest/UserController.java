package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.User;
import com.example.hunters_league.service.UserService;
import com.example.hunters_league.service.dto.UserDTO;
import com.example.hunters_league.web.vm.UserDeleteVM;
import com.example.hunters_league.web.vm.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
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


    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> find(@PathVariable String id) {
        User user = userService.findById(id);
        UserDTO userDTO = userMapper.toDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/findbyemail/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        UserDTO userDTO = userMapper.toDTO(user);
        return ResponseEntity.ok(userDTO);
    }

}