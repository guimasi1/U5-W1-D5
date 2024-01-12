package com.example.U5W1D5;

import com.example.U5W1D5.dao.BuildingsService;
import com.example.U5W1D5.dao.DesksService;
import com.example.U5W1D5.dao.ReservationsService;
import com.example.U5W1D5.dao.UsersService;
import com.example.U5W1D5.entities.*;
import com.github.javafaker.Faker;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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
        // createFakeBuildings();
        // createFakeDesks();
        createFakeUsers();
        interact();
        // usersService.deleteAllUser();

        // Desk desk = desksService.findAll().get(8);
        // desksService.findAll().forEach(System.out::println);
        // desksService.findAvaiblableDesksByDate(LocalDate.now()).forEach(System.out::println);

        // User user = usersService.findAll().get(1);
        // Reservation reservation = new Reservation(LocalDate.now().plusDays(10),user,desk);

        // reservationsService.findByIdAndDelete(UUID.fromString("ec7edceb-9486-4256-8e84-6770a14157fc"));
        // reservationsService.save(reservation);
        // reservationsService.save2(reservation);
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

    public void interact() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String username;
        String email;
        User user;
        System.out.println("Salve.");
        do {
            System.out.println("Inserisca il suo username di almeno 3 lettere.");
            username = scanner.nextLine();
        } while(username.length() < 3);
        if (usersService.findByUsername(username) == null) {
            String usernameToRegister;
            System.out.println("Mi dispiace ma non ci risulta nessun utente con questo username. " +
                    "La preghiamo di inserire i dati per la registrazione.");
            do {
                System.out.println("Inserisca il suo nome di almeno 3 lettere.");
                name = scanner.nextLine();
            } while (name.length() < 3);
            do {
                System.out.println("Inserisca il suo username di almeno 3 lettere.");
                usernameToRegister = scanner.nextLine();
                if (usersService.findByUsername(usernameToRegister) != null) System.out.println("Questo username è già presente nel nostro database.");
            } while (usernameToRegister.length() < 3 || usersService.findByUsername(usernameToRegister) != null);
            do {
                System.out.println("Inserisca la sua mail.");
                email = scanner.nextLine();
            } while (email.length() < 3);

            user = new User(usernameToRegister, name, email);
            usersService.save(user);
        } else {
            user = usersService.findByUsername(username);
        }
        System.out.println("Per quale data vuole prenotare la postazione?");
        int day = 0;
        int month = 0;
        int year;
        do {
            System.out.println("Inserisca l'anno");
            year = Integer.parseInt(scanner.nextLine());
        } while (year < LocalDate.now().getYear());
        int minMonth = 1;
        if(year == LocalDate.now().getYear()) {
            minMonth = LocalDate.now().getMonthValue();
        }
        do {
            System.out.println("Inserisca il mese");
            month = Integer.parseInt(scanner.nextLine());
        } while (month < minMonth || month > 12);
        int maxDay = LocalDate.of(year,month,1).lengthOfMonth();
        int minDay = 1;
        if(year == LocalDate.now().getYear() && month == LocalDate.now().getMonthValue()) {
            minDay = LocalDate.now().getDayOfMonth();
        }
        do {
            System.out.println("Inserisca il giorno");
            day = Integer.parseInt(scanner.nextLine());
        } while (day < minDay  || day > maxDay);

        LocalDate reservationDate = LocalDate.of(year,month,day);
        System.out.println("Questa è la lista delle postazioni disponibili nella data da lei inserita.");
        List<Desk> availableDesks = desksService.findAvaiblableDesksByDate(reservationDate);
        availableDesks.forEach(System.out::println);
        int deskChoice = -1;
        do {
            System.out.println("Abbiamo " + availableDesks.size() + " postazioni disponibili. " +
                    "Quale postazione vuole prenotare? Inserisca un numero da 1 a " + availableDesks.size());
            deskChoice = Integer.parseInt(scanner.nextLine()) - 1;
        } while (deskChoice < -1);
        Reservation reservation = new Reservation(reservationDate, user, availableDesks.get(deskChoice));
        reservationsService.save2(reservation);
        System.out.println("Grazie e arrivederci.");
    }


}
