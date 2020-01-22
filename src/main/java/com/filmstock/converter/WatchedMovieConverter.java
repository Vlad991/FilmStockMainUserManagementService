package com.filmstock.converter;

import com.filmstock.dto.WatchedMovieDTO;
import com.filmstock.entity.WatchedMovie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WatchedMovieConverter extends MovieConverter {
    public WatchedMovieDTO convertToDto(WatchedMovie watchedMovie) {
        WatchedMovieDTO watchedMovieDTO = (WatchedMovieDTO) super.convertToDto(watchedMovie);
        return watchedMovieDTO;
    }

    public WatchedMovie convertToEntity(WatchedMovieDTO watchedMovieDTO) {
        WatchedMovie watchedMovie = (WatchedMovie) super.convertToEntity(watchedMovieDTO);
        return watchedMovie;
    }

    public List<WatchedMovieDTO> convertToListDto(List<WatchedMovie> watchedMovies) {
        return watchedMovies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
