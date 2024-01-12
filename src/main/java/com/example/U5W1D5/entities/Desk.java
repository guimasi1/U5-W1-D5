package com.example.U5W1D5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
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

}
