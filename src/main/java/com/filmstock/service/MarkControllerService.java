package com.filmstock.service;

import com.filmstock.converter.MarkConverter;
import com.filmstock.dto.MarkDTO;
import com.filmstock.entity.Mark;
import com.filmstock.entity.MarkValue;
import com.filmstock.entity.User;
import com.filmstock.service.data.MarkService;
import com.filmstock.service.data.UserService;
import org.springframework.stereotype.Service;

@Service
public class MarkControllerService {
    private MarkConverter markConverter;
    private MarkService markService;
    private UserService userService;

    public MarkControllerService(MarkConverter markConverter, MarkService markService, UserService userService) {
        this.markConverter = markConverter;
        this.markService = markService;
        this.userService = userService;
    }

    public MarkDTO addMark(String userLogin, int movieId, int markValue) {
        User user = userService.findUserByLogin(userLogin);
        Mark mark = new Mark();
        mark.setUser(user);
        mark.setMovieId(movieId);
        mark.setMark(MarkValue.getMarkValue(markValue));
        return markConverter.convertToDto(markService.setMark(mark));
    }

    public MarkDTO getMark(String userLogin, int movieId) {
        return markConverter.convertToDto(markService.getMarkByUserAndMovieId(userLogin, movieId));
    }
}
