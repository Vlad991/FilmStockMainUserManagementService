package com.filmstock.exception;

public class FriendsNotFoundException extends RuntimeException {
    public FriendsNotFoundException(String message) {
        super(message);
    }
}
