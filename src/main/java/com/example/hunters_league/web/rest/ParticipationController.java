package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.Participation;
import com.example.hunters_league.domain.User;
import com.example.hunters_league.service.ParticipationService;
import com.example.hunters_league.service.UserService;
import com.example.hunters_league.service.dto.ParticipationDTO;
import com.example.hunters_league.web.errors.user.UserNotFoundException;
import com.example.hunters_league.web.vm.ParticipationVM;
import com.example.hunters_league.web.vm.mapper.ParticipationMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/participation")
public class ParticipationController {
    private final ParticipationService participationService;
    private final ParticipationMapper participationMapper;
    private final UserService userService;

    public ParticipationController(ParticipationService participationService, ParticipationMapper participationMapper,UserService userService) {
        this.participationService = participationService;
        this.participationMapper = participationMapper;
        this.userService = userService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ParticipationDTO> find(@PathVariable UUID id) {
        Participation participation = participationService.findById(id);
        ParticipationDTO participationDTO = participationMapper.toDTO(participation);
        return ResponseEntity.ok(participationDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ParticipationVM participationVM) {
        try {
            User user = userService.findById(participationVM.getUserId().toString());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        Participation participation = participationMapper.toEntity(participationVM);
        Participation savedParticipation = participationService.save(participation);
        ParticipationDTO participationDTO = participationMapper.toDTO(savedParticipation);
        return ResponseEntity.ok(participationDTO);
    }
}