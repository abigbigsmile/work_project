package com.smile.springboot.exception;


public class NullOrEmptyException extends Exception{

    private static final Integer CODE = 102;
    private String message;

    public NullOrEmptyException() {
        this.message = "The exception is NullOrEmptyException !";
    }

    public NullOrEmptyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static Integer getCODE() {
        return CODE;
    }

}
