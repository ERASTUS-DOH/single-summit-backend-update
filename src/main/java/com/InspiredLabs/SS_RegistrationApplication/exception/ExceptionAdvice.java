package com.InspiredLabs.SS_RegistrationApplication.exception;

import com.InspiredLabs.SS_RegistrationApplication.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<Error> handleException(InvalidUserException e) {
        Error error = new Error(HttpStatus.CONFLICT, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
