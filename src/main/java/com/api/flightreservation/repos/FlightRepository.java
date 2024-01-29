package com.api.flightreservation.repos;

import com.api.flightreservation.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query("SELECT f FROM Flight f WHERE f.departureCity = :departureCity and f.arrivalCity = :arrivalCity and f.dateOfDeparture = :dateOfDeparture")
    List<Flight> findFlight(@Param("departureCity") String departureCity, @Param("arrivalCity") String arrivalCity, @Param("dateOfDeparture") Date dateOfDeparture);

}
