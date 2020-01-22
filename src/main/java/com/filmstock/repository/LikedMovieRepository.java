package com.filmstock.repository;

import com.filmstock.entity.LikedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedMovieRepository extends JpaRepository<LikedMovie, Long> {
}
