package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.DeskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface DesksDAO extends JpaRepository<Desk, UUID> {

    @Query("SELECT d FROM Desk d WHERE d NOT IN (SELECT r.desk FROM Reservation r WHERE r.date = :date)")
    List<Desk> findAvaiblableDesksByDate(@Param("date")LocalDate date);
    List<Desk> findByType(DeskType type);
    List<Desk> findByBuildingCityAndType(String city, DeskType type);
    List<Desk> findByBuildingCity(String city);
    List<Desk> findByDescription(String description);
    List<Desk> findByMaxNumberOfOccupants(int maxNumberOfOccupants);

}
