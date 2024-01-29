package com.api.flightreservation.services;

import com.api.flightreservation.entities.Flight;
import com.api.flightreservation.payload.FlightDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    public FlightDto saveFlight(FlightDto flightDto);
    public List<FlightDto> getFlight(String departureCity, String arrivalCity, Date dateOfDeparture);
    public Optional<Flight> getFlightById(Long flightId);
}
