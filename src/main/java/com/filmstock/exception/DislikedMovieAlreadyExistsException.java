package com.filmstock.exception;

public class DislikedMovieAlreadyExistsException extends RuntimeException {
    public DislikedMovieAlreadyExistsException(String message) {
        super(message);
    }
}
