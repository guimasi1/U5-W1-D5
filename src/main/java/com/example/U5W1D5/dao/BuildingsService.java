package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingsService {
    @Autowired
    private BuildingsDAO buildingsDAO;

    public void save(Building building) {
        buildingsDAO.save(building);
        System.out.println("Building saved.");
    }
}
