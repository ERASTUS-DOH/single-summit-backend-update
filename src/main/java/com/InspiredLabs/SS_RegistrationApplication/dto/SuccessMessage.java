package com.InspiredLabs.SS_RegistrationApplication.dto;

import org.springframework.http.HttpStatus;

public class SuccessMessage {
    private HttpStatus httpStatus;
    private String message;

    public SuccessMessage() {
    }

    public SuccessMessage(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "SuccessMessage{" +
                "message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
