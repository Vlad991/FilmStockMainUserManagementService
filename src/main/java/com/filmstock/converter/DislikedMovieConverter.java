package com.filmstock.converter;

import com.filmstock.dto.DislikedMovieDTO;
import com.filmstock.entity.DislikedMovie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DislikedMovieConverter extends MovieConverter {
    public DislikedMovieDTO convertToDto(DislikedMovie dislikedMovie) {
        DislikedMovieDTO dislikedMovieDTO = (DislikedMovieDTO) super.convertToDto(dislikedMovie);
        return dislikedMovieDTO;
    }

    public DislikedMovie convertToEntity(DislikedMovieDTO dislikedMovieDTO) {
        DislikedMovie dislikedMovie = (DislikedMovie) super.convertToEntity(dislikedMovieDTO);
        return dislikedMovie;
    }

    public List<DislikedMovieDTO> convertToListDto(List<DislikedMovie> dislikedMovies) {
        return dislikedMovies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
