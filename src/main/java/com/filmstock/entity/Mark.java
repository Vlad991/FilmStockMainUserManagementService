package com.filmstock.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Mark extends UtilEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "movie_id", nullable = false)
    private String movie_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "mark", nullable = false)
    private MarkValue mark;
}