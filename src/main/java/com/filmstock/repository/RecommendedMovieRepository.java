package com.filmstock.repository;

import com.filmstock.entity.RecommendedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendedMovieRepository extends JpaRepository<RecommendedMovie, Long> {
    RecommendedMovie findByUser_LoginAndSender_LoginAndMovieId(String userLogin, String senderLogin, int movieId);
    List<RecommendedMovie> findAllByUser_Login(String login);
}
