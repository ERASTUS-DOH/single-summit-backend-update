package com.InspiredLabs.SS_RegistrationApplication.exception;

public class InvalidVerificationCodeException extends Exception{
    public InvalidVerificationCodeException(String error){
        super(error);
    }
}
