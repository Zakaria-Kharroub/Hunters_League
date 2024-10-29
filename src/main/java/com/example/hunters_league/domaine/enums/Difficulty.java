package com.example.hunters_league.domaine.enums;

import lombok.Getter;

@Getter
public enum Difficulty {
    COMMON(1), RARE(2), EPIC(3), LEGENDARY(5);

    private final int value;

    Difficulty(int value) {
        this.value = value;
    }

}
