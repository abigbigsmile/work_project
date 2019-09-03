package com.smile.springboot.exception;

import lombok.Data;

@Data
public class JdbcException extends RuntimeException{

    private static final Integer CODE = 103;

    private String message = "error in operating database !";

    public static Integer getCODE() {
        return CODE;
    }
}
