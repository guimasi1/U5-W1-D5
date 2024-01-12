package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Building;
import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuildingsService {
    @Autowired
    private BuildingsDAO buildingsDAO;

    public void save(Building building) {
        buildingsDAO.save(building);
        System.out.println("Building saved.");
    }


    public List<Building> findAll() {
        return buildingsDAO.findAll();
    }
}
