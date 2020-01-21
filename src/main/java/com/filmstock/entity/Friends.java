package com.filmstock.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "friends")
public class Friends extends UtilEntity {
    @ManyToOne
    @JoinColumn(name = "user_first_id")
    private User userFirst;

    @ManyToOne
    @JoinColumn(name = "user_second_id")
    private User userSecond;
}
