package com.filmstock.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.filmstock.entity.BlockingReason;
import com.filmstock.entity.date.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @NotNull(message = "Login is required")
    private String login;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Surname is required")
    private String surname;

    @NotNull(message = "Birthday is required")
    private Date birthday;

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Phone is required")
    private String phone;

    private String photo;

    private boolean blocked;

    private BlockingReason blockingReason;
}
