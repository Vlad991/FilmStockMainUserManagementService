package com.filmstock.entity;

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
@Table(name = "future_movies")
public class FutureMovie extends UtilMovie {
    @Type(type = "com.filmstock.entity.date.DateType")
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "priority", nullable = false, unique = true)
    private int priority;
}
