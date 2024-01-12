package com.example.U5W1D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID uuid;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;

    public Reservation(LocalDate date, User user, Desk desk) {
        this.date = date;
        this.user = user;
        this.desk = desk;
    }
}
