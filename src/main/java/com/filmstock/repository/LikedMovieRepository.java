package com.filmstock.repository;

import com.filmstock.entity.LikedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedMovieRepository extends JpaRepository<LikedMovie, Long> {
    LikedMovie findByUser_LoginAndMovieId(String login, int movieId);
    List<LikedMovie> findAllByUser_Login(String login);
}
