package com.filmstock.exception;

public class NullUserLoginException extends RuntimeException {
    public NullUserLoginException(String message) {
        super(message);
    }
}
