package com.filmstock.exception;

public class FriendsAlreadyExistException extends RuntimeException {
    public FriendsAlreadyExistException(String message) {
        super(message);
    }
}
