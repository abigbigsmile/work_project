package com.springcloud.apigateway.exception;

public class RateLimiteException extends RuntimeException {

    public RateLimiteException() {
        super();
    }

    public RateLimiteException(String message) {
        super(message);
    }
}
