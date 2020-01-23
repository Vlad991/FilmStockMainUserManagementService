package com.filmstock.exception;

public class LikedMovieAlreadyExistsException extends RuntimeException {
    public LikedMovieAlreadyExistsException(String message) {
        super(message);
    }
}
