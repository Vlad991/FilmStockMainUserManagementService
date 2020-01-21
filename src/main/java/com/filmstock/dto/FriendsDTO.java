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
public class FriendsDTO {
    @NotNull(message = "First user is required")
    private UserDTO userFirst;

    @NotNull(message = "Second user is required")
    private UserDTO userSecond;
}
