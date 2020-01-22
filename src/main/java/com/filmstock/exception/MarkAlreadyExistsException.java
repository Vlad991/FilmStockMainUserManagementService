package com.filmstock.exception;

public class MarkAlreadyExistsException extends RuntimeException {
    public MarkAlreadyExistsException(String message) {
        super(message);
    }
}
