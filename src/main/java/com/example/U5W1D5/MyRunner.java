package com.example.U5W1D5;

import com.example.U5W1D5.dao.BuildingsService;
import com.example.U5W1D5.dao.DesksService;
import com.example.U5W1D5.dao.ReservationsService;
import com.example.U5W1D5.dao.UsersService;
import com.example.U5W1D5.entities.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
       /* createFakeBuildings();
        createFakeDesks();
        createFakeUsers();*/
        Desk desk = desksService.findAll().get(8);
        // desksService.findAll().forEach(System.out::println);
        //desksService.findAvaiblableDesks(LocalDate.now()).forEach(System.out::println);

        User user = usersService.findAll().get(1);
        Reservation reservation = new Reservation(LocalDate.now().plusDays(10),user,desk);
        //reservationsService.save(reservation);
        reservationsService.save2(reservation);
        // desksService.findByType(DeskType.MEETINGSPACE).forEach(System.out::println);
        // desksService.findByCity("Gudrunton").forEach(System.out::println);
        // desksService.findByBuildingCityAndType("Gudrunton",DeskType.OPENSPACE).forEach(System.out::println);

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

    public void createFakeDesks() {
        Faker faker = new Faker();
        for (int i = 0; i < 3; i++) {
            Building building = buildingsService.findAll().get(1);
            Desk desk = new Desk(faker.company().catchPhrase(),DeskType.MEETINGSPACE,faker.number().numberBetween(5,100),building);
            desksService.save(desk);
        }
        for (int i = 0; i < 3; i++) {
            Building building = buildingsService.findAll().get(2);
            Desk desk = new Desk(faker.company().catchPhrase(),DeskType.PRIVATE,faker.number().numberBetween(5,100),building);
            desksService.save(desk);
        }
        for (int i = 0; i < 3; i++) {
            Building building = buildingsService.findAll().get(3);
            Desk desk = new Desk(faker.company().catchPhrase(),DeskType.OPENSPACE,faker.number().numberBetween(5,100),building);
            desksService.save(desk);
        }
    }



}
