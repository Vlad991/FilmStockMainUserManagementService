package com.filmstock.entity;

import com.filmstock.entity.time.Time;
import com.filmstock.entity.date.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "commented_movies")
public class CommentedMovie extends UtilMovie {
    @Column(name = "comment")
    private String comment;

    @Type(type = "com.filmstock.entity.date.DateType")
    @Column(name = "date", nullable = false)
    private Date date;

    @Type(type = "com.filmstock.entity.time.TimeType")
    @Column(name = "time", nullable = false)
    private Time time;
}
