package com.example.hunters_league.repository;

import com.example.hunters_league.domain.Species;
import com.example.hunters_league.domain.enums.SpeciesType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpeciesRepository extends JpaRepository<Species, UUID>{

    List<Species> findByCategory(SpeciesType category);
    Page<Species> findAll(Pageable pageable);


}
