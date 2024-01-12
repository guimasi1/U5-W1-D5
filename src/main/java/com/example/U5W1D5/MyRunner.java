package com.example.U5W1D5;

import com.example.U5W1D5.dao.BuildingsService;
import com.example.U5W1D5.dao.DesksService;
import com.example.U5W1D5.dao.ReservationsService;
import com.example.U5W1D5.dao.UsersService;
import com.example.U5W1D5.entities.Building;
import com.example.U5W1D5.entities.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ReservationsService reservationsService;
    @Autowired
    private BuildingsService buildingsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private DesksService desksService;

    @Override
    public void run(String... args) throws Exception {

    }

    public void createFakeBuildings() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Building building = new Building(faker.address().buildingNumber(),faker.address().streetAddress(),
                    faker.address().city());
            buildingsService.save(building);
        }

    }
    public void createFakeUsers() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            User user = new User(faker.name().username(),faker.name().fullName(),
                    faker.internet().emailAddress());
            usersService.save(user);
        }
    }

}
