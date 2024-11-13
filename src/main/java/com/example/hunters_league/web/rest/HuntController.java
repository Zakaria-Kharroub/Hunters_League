package com.example.hunters_league.web.rest;

import com.example.hunters_league.domain.Hunt;
import com.example.hunters_league.service.HuntService;
import com.example.hunters_league.service.dto.HuntDTO;
import com.example.hunters_league.web.vm.HuntVM;
import com.example.hunters_league.web.vm.mapper.HuntMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/hunt")
public class HuntController {
    private final HuntService huntService;
    private final HuntMapper huntMapper;

    public HuntController(HuntService huntService, HuntMapper huntMapper) {
        this.huntService = huntService;
        this.huntMapper = huntMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<HuntDTO> save(@RequestBody HuntVM huntVM) {
        Hunt hunt = huntMapper.toEntity(huntVM);
        Hunt savedHunt = huntService.save(hunt);
        HuntDTO huntDTO = huntMapper.toDTO(savedHunt);
        return ResponseEntity.ok(huntDTO);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HuntDTO> findById(@PathVariable UUID id) {
        HuntDTO huntDTO = huntService.findById(id);
        return ResponseEntity.ok(huntDTO);
    }
}