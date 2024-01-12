package com.example.U5W1D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    @ToString.Exclude
    private List<Desk> desks;


}
