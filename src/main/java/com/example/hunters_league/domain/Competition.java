package com.example.hunters_league.domain;

import com.example.hunters_league.domain.enums.SpeciesType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Competition {
    @Id
    @GeneratedValue
    private UUID id;

    private String code;

    private String location;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private SpeciesType speciesType;

    private Integer minParticipants;

    private Integer maxParticipants;

    private Boolean openRegistration;

    @OneToMany(mappedBy = "competition")
    private List<Participation> participations;

}
