package com.api.flightreservation.controllers;

import com.api.flightreservation.payload.FindFlightDto;
import com.api.flightreservation.payload.FlightDto;
import com.api.flightreservation.repos.FlightRepository;
import com.api.flightreservation.services.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {
    private FlightService flightService;
    private FlightRepository flightRepository;

    public FlightController(FlightService flightService, FlightRepository flightRepository) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
    }

    @PostMapping("/admin/addFlight")
    public ResponseEntity<FlightDto> addFlight(@Valid @RequestBody FlightDto flightDto) {
        return new ResponseEntity<FlightDto>(flightService.saveFlight(flightDto), HttpStatus.OK);
    }

    @PostMapping("/searchFlights")
    public List<FlightDto> findFlight(@Valid @RequestBody FindFlightDto findFlightDto) {
        String departureCity = findFlightDto.getDepartureCity();
        String arrivalCity = findFlightDto.getArrivalCity();
        Date dateOfDeparture = findFlightDto.getDateOfDeparture();
        return flightService.getFlight(departureCity, arrivalCity, dateOfDeparture);
    }
}
