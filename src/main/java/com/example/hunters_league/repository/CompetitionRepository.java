package com.example.hunters_league.repository;

import com.example.hunters_league.domain.Competition;
import com.example.hunters_league.service.dto.CompetitionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, UUID> {
    Optional<Competition> findById(UUID id);

    @Query("SELECT new com.example.hunters_league.service.dto.CompetitionDTO(c.code,c.location,c.date,count(p)) " +
            "FROM Competition c LEFT JOIN c.participations p"
            + " WHERE c.id = :id"
            + " GROUP BY c.code,c.location,c.date")
    CompetitionDTO getCompetitionWithParticipationsCount(@Param("id") UUID id);


}