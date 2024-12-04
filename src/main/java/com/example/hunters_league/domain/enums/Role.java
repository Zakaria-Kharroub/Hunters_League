package com.example.hunters_league.domain.enums;

import java.util.Set;

public enum Role {
    ADMIN(Set.of(
            Permission.CAN_PARTICIPATE,
            Permission.CAN_VIEW_RANKINGS,
            Permission.CAN_VIEW_COMPETITIONS
    )),
    MEMBER(Set.of(
            Permission.CAN_PARTICIPATE,
            Permission.CAN_VIEW_RANKINGS,
            Permission.CAN_VIEW_COMPETITIONS,
            Permission.CAN_STORE
    )),
    JURY(Set.of(
            Permission.CAN_PARTICIPATE,
            Permission.CAN_VIEW_RANKINGS,
            Permission.CAN_VIEW_COMPETITIONS,
            Permission.CAN_STORE,
            Permission.CAN_MANAGE_COMPETITIONS,
            Permission.CAN_MANAGE_USERS,
            Permission.CAN_MANAGE_SPECIES,
            Permission.CAN_MANAGE_SETTINGS
    ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions){
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions(){
        return permissions;
    }


}
