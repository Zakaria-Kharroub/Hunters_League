package com.example.hunters_league.repository;

import com.example.hunters_league.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, UUID> {
    Optional<Competition> findById(UUID id);
}