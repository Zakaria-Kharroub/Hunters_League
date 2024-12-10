package com.example.hunters_league.repository;

import com.example.hunters_league.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID> {
    Optional<AppUser> findByUsername(String username);

    Optional<AppUser> findById(UUID id);
    Optional<AppUser> findByEmail(String email);


}