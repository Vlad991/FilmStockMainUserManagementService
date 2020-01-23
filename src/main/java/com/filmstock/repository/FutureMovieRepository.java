package com.filmstock.repository;

import com.filmstock.entity.FutureMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FutureMovieRepository extends JpaRepository<FutureMovie, Long> {
    FutureMovie findByUser_LoginAndMovieId(String login, int movieId);
    List<FutureMovie> findAllByUser_Login(String login);
}
