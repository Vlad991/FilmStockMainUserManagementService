package com.filmstock.repository;

import com.filmstock.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    Mark findByUser_LoginAndMovieId(String userLogin, int movieId);
}
