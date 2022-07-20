package com.InspiredLabs.SS_RegistrationApplication.exception;

public class InvalidUserException extends Exception{
    public InvalidUserException(String error){
        super(error);
    }
}
