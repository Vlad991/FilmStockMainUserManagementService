package com.filmstock.repository;

import com.filmstock.entity.DislikedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DislikedMovieRepository extends JpaRepository<DislikedMovie, Long> {
    DislikedMovie findByUser_LoginAndMovieId(String login, int movieId);
    List<DislikedMovie> findAllByUser_Login(String login);
}
