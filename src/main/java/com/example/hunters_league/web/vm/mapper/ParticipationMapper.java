package com.example.hunters_league.web.vm.mapper;

import com.example.hunters_league.domain.Participation;
import com.example.hunters_league.service.dto.ParticipationDTO;
import com.example.hunters_league.web.vm.ParticipationVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParticipationMapper {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "competitionId", target = "competition.id")
    Participation toEntity(ParticipationVM participationVM);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "competition.id", target = "competitionId")
    ParticipationDTO toDTO(Participation participation);
}