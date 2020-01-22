package com.filmstock.repository;

import com.filmstock.entity.DislikedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DislikedMovieRepository extends JpaRepository<DislikedMovie, Long> {
}
