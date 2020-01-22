package com.filmstock.repository;

import com.filmstock.entity.CommentedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentedMovieRepository extends JpaRepository<CommentedMovie, Long> {
}
