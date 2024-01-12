package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Building;
import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.Reservation;
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

    public List<Building> findByName(String name) {
        return buildingsDAO.findByName(name);
    }
    public List<Building> findByAddress(String address) {
        return buildingsDAO.findByAddress(address);
    }
    public List<Building> findByCity(String city) {
        return buildingsDAO.findByCity(city);
    }


}
