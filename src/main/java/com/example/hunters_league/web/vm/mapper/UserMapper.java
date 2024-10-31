package com.example.hunters_league.web.vm.mapper;

import com.example.hunters_league.domain.User;
import com.example.hunters_league.service.dto.UserDTO;
import com.example.hunters_league.web.vm.UserDeleteVM;
import com.example.hunters_league.web.vm.UserLoginVM;
import com.example.hunters_league.web.vm.UserRegisterVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserLoginVM userVM);
    User toEntity(UserRegisterVM userVM);
    UserDTO toDTO(User user);
    User toEntity(UserDeleteVM userDeleteVM);
}