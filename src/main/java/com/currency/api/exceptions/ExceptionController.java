package com.currency.api.exceptions;

import com.currency.api.exceptions.classes.ApiException;
import com.currency.api.exceptions.classes.BadRequestException;
import com.currency.api.exceptions.classes.ForbiddenException;
import com.currency.api.exceptions.classes.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return makeExceptionResponse(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        return makeExceptionResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException ex) {
        return makeExceptionResponse(ex, HttpStatus.FORBIDDEN);
    }

    private ResponseEntity<Object> makeExceptionResponse(Exception ex, HttpStatus status) {
        return new ResponseEntity<>(
                new ApiException(
                        ex.getMessage(),
                        status,
                        LocalDateTime.now()),
                status);
    }
}
