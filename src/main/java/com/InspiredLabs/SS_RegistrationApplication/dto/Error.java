package com.InspiredLabs.SS_RegistrationApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class Error {
    private HttpStatus httpStatus;
    private String message;

}

