package com.example.hunters_league;

import com.example.hunters_league.domain.User;
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
        User user = new User();
        user.setUsername("newUser");
        user.setPassword("validPassword123");
        user.setEmail("newuser@example.com");

        when(authRepository.save(user)).thenReturn(user);

        User registeredUser = authService.register(user);

        assertNotNull(registeredUser);
        assertEquals(user.getUsername(), registeredUser.getUsername());
        verify(authRepository, times(1)).save(user);
    }

    @Test
    void testLoginUserNotFound() {
        User userLogin = new User();
        userLogin.setUsername("nonExistentUser");
        userLogin.setPassword("password");

        when(authRepository.findByUsername(userLogin.getUsername())).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> authService.login(userLogin));
    }

    @Test
    void TestLoginIncorrectPassword() {
        User userLogin = new User();
        userLogin.setUsername("existingUser");
        userLogin.setPassword("wrongPassword");

        User foundUser = new User();
        foundUser.setUsername("existingUser");
        foundUser.setPassword(BCrypt.hashpw("correctPassword", BCrypt.gensalt()));

        when(authRepository.findByUsername(userLogin.getUsername())).thenReturn(Optional.of(foundUser));

        assertThrows(IncorrectPasswordException.class, () -> authService.login(userLogin));
    }

    @Test

    void TestReturnTrueWhenCredentialsAreCorrect() {
        User userLogin = new User();
        userLogin.setUsername("validUser");
        userLogin.setPassword("validPassword");

        User foundUser = new User();
        foundUser.setUsername("validUser");
        foundUser.setPassword(BCrypt.hashpw("validPassword", BCrypt.gensalt()));

        when(authRepository.findByUsername(userLogin.getUsername())).thenReturn(Optional.of(foundUser));

        assertTrue(authService.login(userLogin));
    }
}
