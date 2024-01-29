package com.api.flightreservation.services;

import com.api.flightreservation.entities.Flight;
import com.api.flightreservation.payload.FlightDto;
import com.api.flightreservation.repos.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;
    private ModelMapper modelMapper;

    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FlightDto saveFlight(FlightDto flightDto) {
        try {
            Flight flight = modelMapper.map(flightDto, Flight.class);
            Flight savedFlight = flightRepository.save(flight);
            FlightDto savedFlightDto = modelMapper.map(savedFlight, FlightDto.class);
            return savedFlightDto;

        } catch (Exception ex) {

            throw new RuntimeException("Flight did not save something went wrong !!");
        }

    }

    @Override
    public List<FlightDto> getFlight(String departureCity, String arrivalCity, Date dateOfDeparture) {
        try {
            List<Flight> flight = flightRepository.findFlight(departureCity, arrivalCity, dateOfDeparture);

            List<FlightDto> allFlight = flight.stream().map(f -> {

                return modelMapper.map(f, FlightDto.class);
            }).collect(Collectors.toList());
            return allFlight;

        } catch (Exception ex) {

            throw new RuntimeException("Flight not found something went wrong !!");
        }

    }

    @Override
    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }
}
