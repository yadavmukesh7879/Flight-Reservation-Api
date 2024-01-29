package com.api.flightreservation.controllers;

import com.api.flightreservation.dto.ReservationRequest;
import com.api.flightreservation.entities.Flight;
import com.api.flightreservation.entities.Reservation;
import com.api.flightreservation.services.FlightService;
import com.api.flightreservation.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    FlightService flightService;
    ReservationService reservationService;

    public ReservationController(FlightService flightService, ReservationService reservationService) {
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    @GetMapping("/showReservation")
    public Optional<Flight> showCompleteReservation(@RequestParam("flightId") Long flightId) {
        return flightService.getFlightById(flightId);
    }

    @PostMapping("/completeReservation")
    public ResponseEntity<Reservation> completeReservation(@RequestBody ReservationRequest reservation) {
        return new ResponseEntity<>(reservationService.bookFlight(reservation), HttpStatus.OK);
    }
}
