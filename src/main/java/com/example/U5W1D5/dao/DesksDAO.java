package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DesksDAO extends JpaRepository<Desk, UUID> {
}
