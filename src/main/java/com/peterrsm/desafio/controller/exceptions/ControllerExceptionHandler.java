package com.peterrsm.desafio.controller.exceptions;

import com.peterrsm.desafio.service.exceptions.InvalidUserException;
import com.peterrsm.desafio.service.exceptions.NoFundException;
import com.peterrsm.desafio.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> noValueException(ResourceNotFoundException ex, HttpServletRequest request) {
        String err = "Record do not exist";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), ex.getMessage(), err, request.getRequestURI());

        return ResponseEntity
                .status(status)
                .body(error);
    }

    @ExceptionHandler(NoFundException.class)
    public ResponseEntity<StandardError> noFundException(NoFundException ex, HttpServletRequest request) {
        String err = "Insuficcient fund";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), ex.getMessage(), err, request.getRequestURI());

        return ResponseEntity
                .status(status)
                .body(error);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<StandardError> invalidUserException(InvalidUserException ex, HttpServletRequest request) {
        String err = "Invalid sender";
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), ex.getMessage(), err, request.getRequestURI());

        return ResponseEntity
                .status(status)
                .body(error);
    }
}
