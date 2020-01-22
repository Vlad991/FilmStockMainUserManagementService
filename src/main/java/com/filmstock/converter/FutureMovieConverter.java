package com.filmstock.converter;

import com.filmstock.dto.FutureMovieDTO;
import com.filmstock.entity.FutureMovie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FutureMovieConverter extends MovieConverter {
    public FutureMovieDTO convertToDto(FutureMovie futureMovie) {
        FutureMovieDTO futureMovieDTO = (FutureMovieDTO) super.convertToDto(futureMovie);
        futureMovieDTO.setDate(futureMovie.getDate());
        futureMovieDTO.setPriority(futureMovie.getPriority());
        return futureMovieDTO;
    }

    public FutureMovie convertToEntity(FutureMovieDTO futureMovieDTO) {
        FutureMovie futureMovie = (FutureMovie) super.convertToEntity(futureMovieDTO);
        futureMovie.setDate(futureMovieDTO.getDate());
        futureMovie.setPriority(futureMovie.getPriority());
        return futureMovie;
    }

    public List<FutureMovieDTO> convertToListDto(List<FutureMovie> futureMovies) {
        return futureMovies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
