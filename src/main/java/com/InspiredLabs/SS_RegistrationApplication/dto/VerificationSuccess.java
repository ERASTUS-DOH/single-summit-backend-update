package com.InspiredLabs.SS_RegistrationApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationSuccess {
    private String verificationCode;
    private HttpStatus httpStatus;
    private String message;

}
