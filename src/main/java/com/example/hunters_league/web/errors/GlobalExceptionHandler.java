package com.example.hunters_league.web.errors;

import com.example.hunters_league.web.errors.competition.CompetitionNotFoundException;
import com.example.hunters_league.web.errors.participation.ParticipationNotFoundException;
import com.example.hunters_league.web.errors.user.IncorrectPasswordException;
import com.example.hunters_league.web.errors.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    --------------- user--------------
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<String> handleIncorrectPassword(IncorrectPasswordException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

//   ----------------- competition------------
    @ExceptionHandler(CompetitionNotFoundException.class)
    public ResponseEntity<String> handleCompetitionNotFoundException(CompetitionNotFoundException ex){
        return  new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

//    ----------------- participation------------
    @ExceptionHandler(ParticipationNotFoundException.class)
    public ResponseEntity<String> handleParticipationNotFoundException(ParticipationNotFoundException ex){
        return  new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}
