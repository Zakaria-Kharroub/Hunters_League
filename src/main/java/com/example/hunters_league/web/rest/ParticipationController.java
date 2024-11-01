package com.example.hunters_league.web.rest;

import com.example.hunters_league.service.ParticipationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/participation")
public class ParticipationController {
    private final ParticipationService participationService;

    public ParticipationController(ParticipationService participationService){
        this.participationService=participationService;
    }
}
