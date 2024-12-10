package com.example.hunters_league.domain.enums;

public enum Permission {
    // Permissions pour MEMBER
    CAN_PARTICIPATE,
    CAN_VIEW_RANKINGS,
    CAN_VIEW_COMPETITIONS,

    // Permissions pour JURY
    CAN_STORE,

    // Permissions pour ADMIN
    CAN_MANAGE_COMPETITIONS,
    CAN_MANAGE_USERS,
    CAN_MANAGE_SPECIES,
    CAN_MANAGE_SETTINGS;
}
