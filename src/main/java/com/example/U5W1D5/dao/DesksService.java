package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DesksService {
    @Autowired
    private DesksDAO desksDAO;

    public void save(Desk desk) {
        desksDAO.save(desk);
        System.out.println("Desk saved.");
    }

    public List<Desk> findAll() {
        return desksDAO.findAll();
    }

    public List<Desk> findAvaiblableDesks(LocalDate date) {
        return desksDAO.findAvaiblableDesks(date);
    }



}
