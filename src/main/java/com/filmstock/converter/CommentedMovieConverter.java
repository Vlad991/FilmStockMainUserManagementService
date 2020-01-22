package com.filmstock.converter;

import com.filmstock.dto.CommentedMovieDTO;
import com.filmstock.entity.CommentedMovie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentedMovieConverter extends MovieConverter {
    public CommentedMovieDTO convertToDto(CommentedMovie commentedMovie) {
        CommentedMovieDTO commentedMovieDTO = (CommentedMovieDTO) super.convertToDto(commentedMovie);
        commentedMovieDTO.setComment(commentedMovie.getComment());
        commentedMovieDTO.setDate(commentedMovie.getDate());
        commentedMovieDTO.setTime(commentedMovie.getTime());
        return commentedMovieDTO;
    }

    public CommentedMovie convertToEntity(CommentedMovieDTO commentedMovieDTO) {
        CommentedMovie commentedMovie = (CommentedMovie) super.convertToEntity(commentedMovieDTO);
        commentedMovie.setComment(commentedMovieDTO.getComment());
        commentedMovie.setDate(commentedMovieDTO.getDate());
        commentedMovie.setTime(commentedMovieDTO.getTime());
        return commentedMovie;
    }

    public List<CommentedMovieDTO> convertToListDto(List<CommentedMovie> commentedMovies) {
        return commentedMovies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
