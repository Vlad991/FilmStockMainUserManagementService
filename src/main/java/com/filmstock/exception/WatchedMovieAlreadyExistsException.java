package com.filmstock.exception;

public class WatchedMovieAlreadyExistsException extends RuntimeException {
    public WatchedMovieAlreadyExistsException(String message) {
        super(message);
    }
}
