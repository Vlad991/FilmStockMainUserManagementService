package com.filmstock.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.filmstock.entity.date.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FutureMovieDTO extends UtilMovieDTO implements Comparable<FutureMovieDTO> {
    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Priority is required")
    private int priority;

    @Override
    public int compareTo(FutureMovieDTO o) {
        return (this.getPriority() - o.getPriority());
    }
}
