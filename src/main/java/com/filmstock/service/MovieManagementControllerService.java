package com.filmstock.service;

import com.filmstock.converter.*;
import com.filmstock.dto.*;
import com.filmstock.entity.*;
import com.filmstock.entity.date.Date;
import com.filmstock.entity.time.Time;
import com.filmstock.service.data.MovieService;
import com.filmstock.service.data.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MovieManagementControllerService {
    private WatchedMovieConverter watchedMovieConverter;
    private LikedMovieConverter likedMovieConverter;
    private DislikedMovieConverter dislikedMovieConverter;
    private CommentedMovieConverter commentedMovieConverter;
    private FutureMovieConverter futureMovieConverter;
    private RecommendedMovieConverter recommendedMovieConverter;
    private MovieService movieService;
    private UserService userService;

    public MovieManagementControllerService(WatchedMovieConverter watchedMovieConverter, LikedMovieConverter likedMovieConverter, DislikedMovieConverter dislikedMovieConverter, CommentedMovieConverter commentedMovieConverter, FutureMovieConverter futureMovieConverter, RecommendedMovieConverter recommendedMovieConverter, MovieService movieService, UserService userService) {
        this.watchedMovieConverter = watchedMovieConverter;
        this.likedMovieConverter = likedMovieConverter;
        this.dislikedMovieConverter = dislikedMovieConverter;
        this.commentedMovieConverter = commentedMovieConverter;
        this.futureMovieConverter = futureMovieConverter;
        this.recommendedMovieConverter = recommendedMovieConverter;
        this.movieService = movieService;
        this.userService = userService;
    }

    public WatchedMovieDTO addWatchedMovie(String userLogin, int movieId) {
        User user = userService.findUserByLogin(userLogin);
        WatchedMovie watchedMovie = new WatchedMovie();
        watchedMovie.setUser(user);
        watchedMovie.setMovieId(movieId);
        return watchedMovieConverter.convertToDto(movieService.addWatchedMovie(watchedMovie));
    }

    public boolean movieIsWatched(String userLogin, int movieId) {
        return getWatchedMovie(userLogin, movieId) != null;
    }

    public WatchedMovieDTO getWatchedMovie(String userLogin, int movieId) {
        WatchedMovie watchedMovie = movieService.getWatchedMovieByUserAndMovieId(userLogin, movieId);
        if (watchedMovie == null) {
            return null;
        }
        return watchedMovieConverter.convertToDto(watchedMovie);
    }

    public LikedMovieDTO addLikedMovie(String userLogin, int movieId) {
        User user = userService.findUserByLogin(userLogin);
        if (movieIsDisliked(userLogin, movieId)) {
            movieService.removeDislikedMovie(userLogin, movieId);
        }
        LikedMovie likedMovie = new LikedMovie();
        likedMovie.setUser(user);
        likedMovie.setMovieId(movieId);
        return likedMovieConverter.convertToDto(movieService.addLikedMovie(likedMovie));
    }

    public boolean movieIsLiked(String userLogin, int movieId) {
        return getLikedMovie(userLogin, movieId) != null;
    }

    public LikedMovieDTO getLikedMovie(String userLogin, int movieId) {
        LikedMovie likedMovie = movieService.getLikedMovieByUserAndMovieId(userLogin, movieId);
        if (likedMovie == null) {
            return null;
        }
        return likedMovieConverter.convertToDto(likedMovie);
    }

    public DislikedMovieDTO addDislikeMovie(String userLogin, int movieId) {
        User user = userService.findUserByLogin(userLogin);
        if (movieIsLiked(userLogin, movieId)) {
            movieService.removeLikedMovie(userLogin, movieId);
        }
        DislikedMovie dislikedMovie = new DislikedMovie();
        dislikedMovie.setUser(user);
        dislikedMovie.setMovieId(movieId);
        return dislikedMovieConverter.convertToDto(movieService.addDislikedMovie(dislikedMovie));
    }

    public boolean movieIsDisliked(String userLogin, int movieId) {
        return getDislikedMovie(userLogin, movieId) != null;
    }

    public DislikedMovieDTO getDislikedMovie(String userLogin, int movieId) {
        DislikedMovie dislikedMovie = movieService.getDislikedMovieByUserAndMovieId(userLogin, movieId);
        if (dislikedMovie == null) {
            return null;
        }
        return dislikedMovieConverter.convertToDto(dislikedMovie);
    }

    public CommentedMovieDTO addCommentedMovie(String userLogin,
                                               int movieId,
                                               String comment,
                                               Date commentDate,
                                               Time commentTime) {
        User user = userService.findUserByLogin(userLogin);
        CommentedMovie commentedMovie = new CommentedMovie();
        commentedMovie.setUser(user);
        commentedMovie.setMovieId(movieId);
        commentedMovie.setComment(comment);
        commentedMovie.setDate(commentDate);
        commentedMovie.setTime(commentTime);
        return commentedMovieConverter.convertToDto(movieService.addCommentedMovie(commentedMovie));
    }

    public FutureMovieDTO addFutureMovie(String userLogin, int movieId, Date date, int priority) {
        User user = userService.findUserByLogin(userLogin);
        FutureMovie futureMovie = new FutureMovie();
        futureMovie.setUser(user);
        futureMovie.setMovieId(movieId);
        futureMovie.setDate(date);
        futureMovie.setPriority(priority);
        return futureMovieConverter.convertToDto(movieService.addFutureMovie(futureMovie));
    }

    public List<FutureMovieDTO> getPrioritySortedFutureMovieList(String userLogin) {
        User user = userService.findUserByLogin(userLogin);
        List<FutureMovie> futureMovieList = movieService.getAllFutureMoviesByUser(userLogin);
        List<FutureMovieDTO> futureMovieDTOList = futureMovieConverter.convertToListDto(futureMovieList);
        Collections.sort(futureMovieDTOList);
        return futureMovieDTOList;
    }

    public RecommendedMovieDTO addRecommendedMovie(String userLogin, String senderLogin, int movieId, String message) {
        User user = userService.findUserByLogin(userLogin);
        User sender = userService.findUserByLogin(senderLogin);
        RecommendedMovie recommendedMovie = new RecommendedMovie();
        recommendedMovie.setUser(user);
        recommendedMovie.setSender(sender);
        recommendedMovie.setMovieId(movieId);
        recommendedMovie.setMessage(message);
        return recommendedMovieConverter.convertToDto(movieService.addRecommendedMovie(recommendedMovie));
    }
}
