package com.filmstock.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "recommended_movies")
public class RecommendedMovie extends UtilMovie {
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(name = "message")
    private String message;
}
