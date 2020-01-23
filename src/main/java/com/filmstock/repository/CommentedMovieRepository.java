package com.filmstock.repository;

import com.filmstock.entity.CommentedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentedMovieRepository extends JpaRepository<CommentedMovie, Long> {
    CommentedMovie findByUser_LoginAndMovieId(String login, int movieId);
    List<CommentedMovie> findAllByUser_Login(String login);
}
