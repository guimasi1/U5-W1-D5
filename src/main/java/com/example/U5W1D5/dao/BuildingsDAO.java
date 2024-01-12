package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingsDAO extends JpaRepository<Building, Long> {
    List<Building> findByName(String name);
    List<Building> findByAddress(String address);
    List<Building> findByCity(String city);

}
