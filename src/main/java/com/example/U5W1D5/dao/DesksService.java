package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.DeskType;
import com.example.U5W1D5.entities.Reservation;
import com.example.U5W1D5.entities.User;
import com.example.U5W1D5.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class DesksService {
    @Autowired
    private DesksDAO desksDAO;

    public void save(Desk desk) {
        desksDAO.save(desk);
        System.out.println("Desk saved.");
    }

    public Desk findById(UUID uuid) throws ItemNotFoundException {
        return desksDAO.findById(uuid).orElseThrow(() -> new ItemNotFoundException(uuid));
    }

    public List<Desk> findAll() {
        return desksDAO.findAll();
    }

    public List<Desk> findAvaiblableDesks(LocalDate date) {
        return desksDAO.findAvaiblableDesks(date);
    }

    public List<Desk> findByType(DeskType deskType) {
        return desksDAO.findByType(deskType);
    }

    public List<Desk> findByBuildingCityAndType(String city, DeskType type) {
        return desksDAO.findByBuildingCityAndType(city, type);
    }
    public List<Desk> findByCity(String city) {
        return desksDAO.findByBuildingCity(city);
    }


}
