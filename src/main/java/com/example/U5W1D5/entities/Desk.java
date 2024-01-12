package com.example.U5W1D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "desks")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID uuid;

    private String description;

    @Enumerated(EnumType.STRING)
    private DeskType type;

    private int maxNumberOfOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "desk")
    @ToString.Exclude
    private List<Reservation> reservations;

    public Desk(String description, DeskType type, int maxNumberOfOccupants, Building building) {
        this.description = description;
        this.type = type;
        this.maxNumberOfOccupants = maxNumberOfOccupants;
        this.building = building;
    }
}
