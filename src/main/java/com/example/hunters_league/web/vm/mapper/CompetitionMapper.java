package com.example.hunters_league.web.vm.mapper;

import com.example.hunters_league.domain.Competition;
import com.example.hunters_league.service.dto.CompetitionDTO;
import com.example.hunters_league.web.vm.CompetitionSaveVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionDTO toDTO(Competition competition);
    Competition toEntity(CompetitionSaveVM competitionSaveVM);

}