package com.example.hunters_league.web.vm.mapper;

import com.example.hunters_league.domain.Hunt;
import com.example.hunters_league.service.dto.HuntDTO;
import com.example.hunters_league.web.vm.HuntVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HuntMapper {

    @Mapping(source = "participationId", target = "participation.id")
    @Mapping(source = "speciesId", target = "species.id")
    Hunt toEntity(HuntVM huntVM);

    @Mapping(source = "participation.id", target = "participationId")
    @Mapping(source = "species.id", target = "speciesId")
    HuntDTO toDTO(Hunt hunt);
}