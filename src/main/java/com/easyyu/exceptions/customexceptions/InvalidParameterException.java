package com.easyyu.exceptions.customexceptions;

public class InvalidParameterException extends RuntimeException {

    private String message;

    public InvalidParameterException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
