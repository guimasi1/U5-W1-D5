package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesksService {
    @Autowired
    private DesksDAO desksDAO;

    public void save(Desk desk) {
        desksDAO.save(desk);
        System.out.println("Desk saved.");
    }

}
