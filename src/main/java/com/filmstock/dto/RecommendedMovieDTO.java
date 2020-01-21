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
public class RecommendedMovieDTO extends UtilMovieDTO {
    @NotNull(message = "Sender is required")
    private UserDTO sender;

    private String message;
}
