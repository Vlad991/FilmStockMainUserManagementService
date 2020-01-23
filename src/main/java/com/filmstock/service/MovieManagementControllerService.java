package com.filmstock.service;

import com.filmstock.converter.*;
import com.filmstock.service.data.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieManagementControllerService {
    private WatchedMovieConverter watchedMovieConverter;
    private LikedMovieConverter likedMovieConverter;
    private DislikedMovieConverter dislikedMovieConverter;
    private CommentedMovieConverter commentedMovieConverter;
    private FutureMovieConverter futureMovieConverter;
    private RecommendedMovieConverter recommendedMovieConverter;
    private MovieService movieService;

    public MovieManagementControllerService(WatchedMovieConverter watchedMovieConverter, LikedMovieConverter likedMovieConverter, DislikedMovieConverter dislikedMovieConverter, CommentedMovieConverter commentedMovieConverter, FutureMovieConverter futureMovieConverter, RecommendedMovieConverter recommendedMovieConverter, MovieService movieService) {
        this.watchedMovieConverter = watchedMovieConverter;
        this.likedMovieConverter = likedMovieConverter;
        this.dislikedMovieConverter = dislikedMovieConverter;
        this.commentedMovieConverter = commentedMovieConverter;
        this.futureMovieConverter = futureMovieConverter;
        this.recommendedMovieConverter = recommendedMovieConverter;
        this.movieService = movieService;
    }

    //todo
}
