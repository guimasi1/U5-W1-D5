package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsDAO reservationsDAO;

    public void save(Reservation reservation) {
        reservationsDAO.save(reservation);
        System.out.println("Reservation saved.");
    }
}
