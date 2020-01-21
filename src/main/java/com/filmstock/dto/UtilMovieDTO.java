package com.filmstock.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtilMovieDTO {
    @NotNull(message = "User is required")
    private UserDTO user;

    @NotNull(message = "Movie id is required")
    private int movieId;
}
