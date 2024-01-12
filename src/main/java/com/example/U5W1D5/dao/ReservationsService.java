package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.Reservation;
import com.example.U5W1D5.entities.User;
import com.example.U5W1D5.exceptions.ItemNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsDAO reservationsDAO;

    @Autowired
    private DesksDAO desksDAO;

    @Autowired
    private UsersDAO usersDAO;

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

    public Reservation findById(UUID uuid) throws ItemNotFoundException {
        return reservationsDAO.findById(uuid).orElseThrow(() -> new ItemNotFoundException(uuid));
    }

    public void save2(Reservation reservation) {
        List<Desk> availableDesks = desksDAO.findAvaiblableDesks(reservation.getDate());
        boolean isDeskAvailable = availableDesks.stream()
                .anyMatch(desk -> desk.getUuid().equals(reservation.getDesk().getUuid()));
        List<Reservation> userReservations = reservationsDAO.findByUser(reservation.getUser());
        boolean hasUserAlreadyReservedForTheDate = userReservations.stream()
                .anyMatch(reservation1 -> reservation1.getDate().equals(reservation.getDate()));
        if(isDeskAvailable) {
            if(!hasUserAlreadyReservedForTheDate) {
                reservationsDAO.save(reservation);
                System.out.println("Reservation saved.");
            } else {
                System.out.println("The user has already a reservation for the following date: " + reservation.getDate());
            }
        } else {
            System.out.println("Desk is not available.");
        }
    }

    public List<Reservation> findAll() {
        return reservationsDAO.findAll();
    }

    public List<Reservation> findByDate(LocalDate date) {
        return reservationsDAO.findByDate(date);
    }

}
