package com.filmstock.service.data;

import com.filmstock.entity.Mark;
import com.filmstock.exception.MarkAlreadyExistsException;
import com.filmstock.exception.MarkNotFoundException;
import com.filmstock.repository.MarkRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MarkService {
    private MarkRepository markRepository;

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Transactional
    public void saveMark(Mark mark) {
        Mark existingMark = markRepository
                .findByUser_LoginAndMovieId(
                        mark.getUser().getLogin(),
                        mark.getMovieId());
        if (existingMark != null) {
            throw new MarkAlreadyExistsException("Mark is already set");
        }
        markRepository.save(mark);
    }

    @Transactional
    public void setMark(Mark mark) {
        Mark existingMark = markRepository
                .findByUser_LoginAndMovieId(
                        mark.getUser().getLogin(),
                        mark.getMovieId());
        if (existingMark == null) {
            throw new MarkNotFoundException();
        }
        existingMark.setMark(mark.getMark());
        markRepository.save(existingMark);
    }
}
