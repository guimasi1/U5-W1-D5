package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.Reservation;
import com.example.U5W1D5.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsDAO reservationsDAO;

    @Autowired
    private DesksDAO desksDAO;

    public void save(Reservation reservation) {
        List<Desk> availableDesks = desksDAO.findAvaiblableDesks(reservation.getDate());
        boolean isDeskAvailable = availableDesks.stream()
                .anyMatch(desk -> desk.getUuid().equals(reservation.getDesk().getUuid()));
        if(isDeskAvailable) {
        reservationsDAO.save(reservation);
        System.out.println("Reservation saved.");
        } else {

            System.out.println("Desk is not available.");
        }
    }
    public List<Reservation> findAll() {
        return reservationsDAO.findAll();
    }
}
