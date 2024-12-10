package com.example.hunters_league.web.vm.mapper;

import com.example.hunters_league.domain.AppUser;
import com.example.hunters_league.service.dto.UserDTO;
import com.example.hunters_league.web.vm.UserDeleteVM;
import com.example.hunters_league.web.vm.UserLoginVM;
import com.example.hunters_league.web.vm.UserRegisterVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "cin", source = "cin")
    @Mapping(target = "nationality", source = "nationality")
    @Mapping(target = "role", source = "role")
    AppUser toEntity(UserRegisterVM userVM);

    UserDTO toDTO(AppUser appUser);
    AppUser toEntity(UserLoginVM userVM);
    AppUser toEntity(UserDeleteVM userDeleteVM);
}