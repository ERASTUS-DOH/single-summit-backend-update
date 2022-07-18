package com.InspiredLabs.SS_RegistrationApplication.service.qrcodeGenetator;

public class DataTooLongException extends IllegalArgumentException{
    public DataTooLongException() {}


    public DataTooLongException(String msg) {
        super(msg);
    }
}
