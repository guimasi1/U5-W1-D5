package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingsDAO extends JpaRepository<Building, Long> {
}
