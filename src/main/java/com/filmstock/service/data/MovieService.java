package com.filmstock.service.data;

import com.filmstock.entity.*;
import com.filmstock.exception.DislikedMovieAlreadyExistsException;
import com.filmstock.exception.LikedMovieAlreadyExistsException;
import com.filmstock.exception.UserNotFoundException;
import com.filmstock.exception.WatchedMovieAlreadyExistsException;
import com.filmstock.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieService {
    private WatchedMovieRepository watchedMovieRepository;
    private LikedMovieRepository likedMovieRepository;
    private DislikedMovieRepository dislikedMovieRepository;
    private CommentedMovieRepository commentedMovieRepository;
    private FutureMovieRepository futureMovieRepository;
    private RecommendedMovieRepository recommendedMovieRepository;
    private UserRepository userRepository;

    public MovieService(WatchedMovieRepository watchedMovieRepository, LikedMovieRepository likedMovieRepository, DislikedMovieRepository dislikedMovieRepository, CommentedMovieRepository commentedMovieRepository, FutureMovieRepository futureMovieRepository, RecommendedMovieRepository recommendedMovieRepository, UserRepository userRepository) {
        this.watchedMovieRepository = watchedMovieRepository;
        this.likedMovieRepository = likedMovieRepository;
        this.dislikedMovieRepository = dislikedMovieRepository;
        this.commentedMovieRepository = commentedMovieRepository;
        this.futureMovieRepository = futureMovieRepository;
        this.recommendedMovieRepository = recommendedMovieRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public WatchedMovie addWatchedMovie(WatchedMovie watchedMovie) {
        WatchedMovie existingWatchedMovie = watchedMovieRepository
                .findByUser_LoginAndMovieId(
                        watchedMovie.getUser().getLogin(),
                        watchedMovie.getMovieId());
        User user = userRepository.findByLogin(watchedMovie.getUser().getLogin());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (existingWatchedMovie != null) {
            throw new WatchedMovieAlreadyExistsException("Movie already added to watched");
        }
        return watchedMovieRepository.save(watchedMovie);
    }

    @Transactional
    public List<WatchedMovie> getAllWatchedMoviesByUser(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return watchedMovieRepository.findAllByUser_Login(login);
    }

    @Transactional
    public LikedMovie addLikedMovie(LikedMovie likedMovie) {
        LikedMovie existingLikedMovie = likedMovieRepository
                .findByUser_LoginAndMovieId(
                        likedMovie.getUser().getLogin(),
                        likedMovie.getMovieId());
        User user = userRepository.findByLogin(likedMovie.getUser().getLogin());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (existingLikedMovie != null) {
            throw new LikedMovieAlreadyExistsException("Movie already liked");
        }
        return likedMovieRepository.save(likedMovie);
    }

    @Transactional
    public List<LikedMovie> getAllLikedMoviesByUser(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return likedMovieRepository.findAllByUser_Login(login);
    }

    @Transactional
    public DislikedMovie addDislikedMovie(DislikedMovie dislikedMovie) {
        DislikedMovie existingDislikedMovie = dislikedMovieRepository
                .findByUser_LoginAndMovieId(
                        dislikedMovie.getUser().getLogin(),
                        dislikedMovie.getMovieId());
        User user = userRepository.findByLogin(dislikedMovie.getUser().getLogin());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (existingDislikedMovie != null) {
            throw new DislikedMovieAlreadyExistsException("Movie already disliked");
        }
        return dislikedMovieRepository.save(dislikedMovie);
    }

    @Transactional
    public List<DislikedMovie> getAllDislikedMoviesByUser(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return dislikedMovieRepository.findAllByUser_Login(login);
    }

    @Transactional
    public CommentedMovie addCommentedMovie(CommentedMovie commentedMovie) {
        User user = userRepository.findByLogin(commentedMovie.getUser().getLogin());
        if (user == null) {
            throw new UserNotFoundException();
        }
        return commentedMovieRepository.save(commentedMovie);
    }

    @Transactional
    public List<CommentedMovie> getAllCommentedMoviesByUser(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return commentedMovieRepository.findAllByUser_Login(login);
    }

    @Transactional
    public FutureMovie addFutureMovie(FutureMovie futureMovie) {
        FutureMovie existingFutureMovie = futureMovieRepository
                .findByUser_LoginAndMovieId(
                        futureMovie.getUser().getLogin(),
                        futureMovie.getMovieId());
        User user = userRepository.findByLogin(futureMovie.getUser().getLogin());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (existingFutureMovie != null) {
            existingFutureMovie.setPriority(futureMovie.getPriority());
            existingFutureMovie.setDate(futureMovie.getDate());
            return futureMovieRepository.save(existingFutureMovie);
        } else {
            return futureMovieRepository.save(futureMovie);
        }
    }

    @Transactional
    public List<FutureMovie> getAllFutureMoviesByUser(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return futureMovieRepository.findAllByUser_Login(login);
    }

    @Transactional
    public RecommendedMovie addRecommendedMovie(RecommendedMovie recommendedMovie) {
        RecommendedMovie existingRecommendedMovie = recommendedMovieRepository
                .findByUser_LoginAndSender_LoginAndMovieId(
                        recommendedMovie.getUser().getLogin(),
                        recommendedMovie.getSender().getLogin(),
                        recommendedMovie.getMovieId());
        User user = userRepository.findByLogin(recommendedMovie.getUser().getLogin());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (existingRecommendedMovie != null) {
            existingRecommendedMovie.setMessage(recommendedMovie.getMessage());
            return recommendedMovieRepository.save(existingRecommendedMovie);
        } else {
            return recommendedMovieRepository.save(recommendedMovie);
        }
    }

    @Transactional
    public List<RecommendedMovie> getAllRecommendedMoviesByUser(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return recommendedMovieRepository.findAllByUser_Login(login);
    }
}
