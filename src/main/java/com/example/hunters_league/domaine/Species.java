package com.example.hunters_league.domaine;

import com.example.hunters_league.domaine.enums.Difficulty;
import com.example.hunters_league.domaine.enums.SpeciesType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private SpeciesType category;

    private Double minimumWeight;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private Integer points;

}
