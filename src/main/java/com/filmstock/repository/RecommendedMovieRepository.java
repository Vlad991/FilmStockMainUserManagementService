package com.filmstock.repository;

import com.filmstock.entity.RecommendedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendedMovieRepository extends JpaRepository<RecommendedMovie, Long> {
}
