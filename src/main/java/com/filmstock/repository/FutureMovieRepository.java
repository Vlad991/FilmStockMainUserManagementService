package com.filmstock.repository;

import com.filmstock.entity.FutureMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FutureMovieRepository extends JpaRepository<FutureMovie, Long> {
}
