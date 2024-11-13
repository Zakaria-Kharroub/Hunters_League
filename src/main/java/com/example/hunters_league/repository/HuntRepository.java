package com.example.hunters_league.repository;

import com.example.hunters_league.domain.Hunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HuntRepository extends JpaRepository<Hunt, UUID> {
}