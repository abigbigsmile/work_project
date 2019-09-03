package com.smile.springboot.exception;

public class NotLoginException extends  Exception{

    private static final Integer CODE = 101;
    private String message;

    public NotLoginException() {
        message = "The exception is NotLoginException";
    }

    public NotLoginException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Integer getCODE() {
        return CODE;
    }
}
