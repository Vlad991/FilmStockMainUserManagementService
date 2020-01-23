package com.filmstock.exception.handler;

import com.filmstock.dto.ErrorInfo;
import com.filmstock.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerService {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            UserAlreadyExistsException.class,
            UserNotFoundException.class,
            UserAlreadyBlockedException.class,
            UserNotBlockedException.class,
            FriendsAlreadyExistException.class,
            FriendsNotFoundException.class,
            FriendRequestAlreadyExistsException.class,
            FriendRequestNotFoundException.class,
            MarkAlreadyExistsException.class,
            MarkNotFoundException.class,
            WatchedMovieAlreadyExistsException.class,
            LikedMovieAlreadyExistsException.class,
            DislikedMovieAlreadyExistsException.class,
            NullUserLoginException.class
    })
    @ResponseBody
    public ErrorInfo exceptionHandler(Exception ex){
        return new ErrorInfo().setTimestamp(System.currentTimeMillis())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.toString());
    }
}
