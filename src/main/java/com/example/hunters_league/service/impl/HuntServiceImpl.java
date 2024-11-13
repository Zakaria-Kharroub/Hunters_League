package com.example.hunters_league.service.impl;

import com.example.hunters_league.domain.Hunt;
import com.example.hunters_league.repository.HuntRepository;
import com.example.hunters_league.service.HuntService;
import com.example.hunters_league.service.dto.HuntDTO;
import com.example.hunters_league.web.vm.mapper.HuntMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HuntServiceImpl implements HuntService {

    private final HuntRepository huntRepository;
    private final HuntMapper huntMapper;

    public HuntServiceImpl(HuntRepository huntRepository, HuntMapper huntMapper) {
        this.huntRepository = huntRepository;
        this.huntMapper = huntMapper;
    }

    @Override
    public Hunt save(Hunt hunt) {
        return huntRepository.save(hunt);
    }

    @Override
    public HuntDTO findById(UUID id) {
        Hunt hunt = huntRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hunt not found"));
        return huntMapper.toDTO(hunt);
    }
}