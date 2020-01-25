package com.filmstock.service.data;

import com.filmstock.entity.Mark;
import com.filmstock.exception.MarkAlreadyExistsException;
import com.filmstock.exception.MarkNotFoundException;
import com.filmstock.exception.NullUserLoginException;
import com.filmstock.repository.MarkRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MarkService {
    private MarkRepository markRepository;

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public Mark getMarkByUserAndMovieId(String login, int movieId) {
        if (login == null) {
            throw new NullUserLoginException("User login is required");
        }
        return markRepository.findByUser_LoginAndMovieId(login, movieId);
    }

    @Transactional
    public Mark setMark(Mark mark) {
        if (mark.getUser() == null) {
            throw new NullUserLoginException("User login is required");
        }
        Mark existingMark = markRepository
                .findByUser_LoginAndMovieId(
                        mark.getUser().getLogin(),
                        mark.getMovieId());
        if (existingMark != null) {
            existingMark.setMark(mark.getMark());
            return markRepository.save(existingMark);
        } else {
            return markRepository.save(mark);
        }
    }
}
