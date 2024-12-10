package com.example.hunters_league;

import com.example.hunters_league.domain.AppUser;
import com.example.hunters_league.repository.AuthRepository;
import com.example.hunters_league.service.impl.AuthServiceImpl;
import com.example.hunters_league.web.errors.user.IncorrectPasswordException;
import com.example.hunters_league.web.errors.user.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    @Mock
    private AuthRepository authRepository;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserUnique() {
        AppUser appUser = new AppUser();
        appUser.setUsername("newUser");
        appUser.setPassword("validPassword123");
        appUser.setEmail("newuser@example.com");

        when(authRepository.save(appUser)).thenReturn(appUser);

        AppUser registeredAppUser = authService.register(appUser);

        assertNotNull(registeredAppUser);
        assertEquals(appUser.getUsername(), registeredAppUser.getUsername());
        verify(authRepository, times(1)).save(appUser);
    }

    @Test
    void testLoginUserNotFound() {
        AppUser appUserLogin = new AppUser();
        appUserLogin.setUsername("nonExistentUser");
        appUserLogin.setPassword("password");

        when(authRepository.findByUsername(appUserLogin.getUsername())).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> authService.login(appUserLogin));
    }

    @Test
    void TestLoginIncorrectPassword() {
        AppUser appUserLogin = new AppUser();
        appUserLogin.setUsername("existingUser");
        appUserLogin.setPassword("wrongPassword");

        AppUser foundAppUser = new AppUser();
        foundAppUser.setUsername("existingUser");
        foundAppUser.setPassword(BCrypt.hashpw("correctPassword", BCrypt.gensalt()));

        when(authRepository.findByUsername(appUserLogin.getUsername())).thenReturn(Optional.of(foundAppUser));

        assertThrows(IncorrectPasswordException.class, () -> authService.login(appUserLogin));
    }

    @Test

    void TestReturnTrueWhenCredentialsAreCorrect() {
        AppUser appUserLogin = new AppUser();
        appUserLogin.setUsername("validUser");
        appUserLogin.setPassword("validPassword");

        AppUser foundAppUser = new AppUser();
        foundAppUser.setUsername("validUser");
        foundAppUser.setPassword(BCrypt.hashpw("validPassword", BCrypt.gensalt()));

        when(authRepository.findByUsername(appUserLogin.getUsername())).thenReturn(Optional.of(foundAppUser));

        assertTrue(authService.login(appUserLogin));
    }
}
