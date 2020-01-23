package com.filmstock.repository;

import com.filmstock.entity.WatchedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchedMovieRepository extends JpaRepository<WatchedMovie, Long> {
    WatchedMovie findByUser_LoginAndMovieId(String login, int movieId);
    List<WatchedMovie> findAllByUser_Login(String login);
}
