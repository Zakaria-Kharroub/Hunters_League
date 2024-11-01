package com.example.hunters_league.repository;

import com.example.hunters_league.domain.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipationRepository extends JpaRepository<Participation ,UUID> {
}
