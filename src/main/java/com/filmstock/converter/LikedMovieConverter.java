package com.filmstock.converter;

import com.filmstock.dto.LikedMovieDTO;
import com.filmstock.entity.LikedMovie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikedMovieConverter extends MovieConverter {
    public LikedMovieDTO convertToDto(LikedMovie likedMovie) {
        LikedMovieDTO likedMovieDTO = (LikedMovieDTO) super.convertToDto(likedMovie);
        return likedMovieDTO;
    }

    public LikedMovie convertToEntity(LikedMovieDTO likedMovieDTO) {
        LikedMovie likedMovie = (LikedMovie) super.convertToEntity(likedMovieDTO);
        return likedMovie;
    }

    public List<LikedMovieDTO> convertToListDto(List<LikedMovie> likedMovies) {
        return likedMovies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
