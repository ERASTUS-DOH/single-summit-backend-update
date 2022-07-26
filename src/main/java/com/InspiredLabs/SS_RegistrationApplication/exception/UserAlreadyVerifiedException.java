package com.InspiredLabs.SS_RegistrationApplication.exception;

public class UserAlreadyVerifiedException extends Exception{
    public UserAlreadyVerifiedException(String error){
        super(error);
    }
}
