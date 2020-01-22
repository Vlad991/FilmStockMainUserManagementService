package com.filmstock.converter;

import com.filmstock.dto.RecommendedMovieDTO;
import com.filmstock.entity.RecommendedMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecommendedMovieConverter extends MovieConverter {
    @Autowired
    private UserConverter userConverter;

    public RecommendedMovieDTO convertToDto(RecommendedMovie recommendedMovie) {
        RecommendedMovieDTO recommendedMovieDTO = (RecommendedMovieDTO) super.convertToDto(recommendedMovie);
        recommendedMovieDTO.setSender(userConverter.convertToDto(recommendedMovie.getSender()));
        recommendedMovieDTO.setMessage(recommendedMovie.getMessage());
        return recommendedMovieDTO;
    }

    public RecommendedMovie convertToEntity(RecommendedMovieDTO recommendedMovieDTO) {
        RecommendedMovie recommendedMovie = (RecommendedMovie) super.convertToEntity(recommendedMovieDTO);
        recommendedMovie.setSender(userConverter.convertToEntity(recommendedMovieDTO.getSender()));
        recommendedMovie.setMessage(recommendedMovieDTO.getMessage());
        return recommendedMovie;
    }

    public List<RecommendedMovieDTO> convertToListDto(List<RecommendedMovie> recommendedMovies) {
        return recommendedMovies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
