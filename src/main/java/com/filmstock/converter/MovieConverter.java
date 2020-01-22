package com.filmstock.converter;

import com.filmstock.dto.UtilMovieDTO;
import com.filmstock.entity.UtilMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {
    @Autowired
    private UserConverter userConverter;

    protected UtilMovieDTO convertToDto(UtilMovie utilMovie) {
        UtilMovieDTO utilMovieDTO = new UtilMovieDTO();
        utilMovieDTO.setUser(userConverter.convertToDto(utilMovie.getUser()));
        utilMovieDTO.setMovieId(utilMovie.getMovieId());
        return utilMovieDTO;
    }

    protected UtilMovie convertToEntity(UtilMovieDTO utilMovieDTO) {
        UtilMovie utilMovie = new UtilMovie();
        utilMovie.setUser(userConverter.convertToEntity(utilMovieDTO.getUser()));
        utilMovie.setMovieId(utilMovieDTO.getMovieId());
        return utilMovie;
    }
}
