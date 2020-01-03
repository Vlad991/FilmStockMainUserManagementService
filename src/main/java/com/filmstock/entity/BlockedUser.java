package com.filmstock.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "blocked_users")
public class BlockedUser extends UtilEntity {
    @OneToOne
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "blocking_reason")
    private BlockingReason blockingReason;
}
