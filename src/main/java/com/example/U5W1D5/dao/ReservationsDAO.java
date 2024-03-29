package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.Reservation;
import com.example.U5W1D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationsDAO extends JpaRepository<Reservation, UUID> {

    List<Reservation> findByUser(User user);
    List<Reservation> findByDate(LocalDate date);
}
