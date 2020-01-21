package com.filmstock.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.filmstock.entity.date.Date;
import com.filmstock.entity.time.Time;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentedMovieDTO extends UtilMovieDTO {
    @NotNull(message = "Comment is required")
    private String comment;

    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Time is required")
    private Time time;
}
