package com.api.flightreservation.services;

import com.api.flightreservation.dto.ReservationRequest;
import com.api.flightreservation.entities.Flight;
import com.api.flightreservation.entities.Passenger;
import com.api.flightreservation.entities.Reservation;
import com.api.flightreservation.exceptions.ResourceNotFoundException;
import com.api.flightreservation.repos.PassengerRepository;
import com.api.flightreservation.repos.ReservationRepository;
import com.api.flightreservation.util.EmailUtil;
import com.api.flightreservation.util.PDFGenerator;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class ReservationServiceImpl implements ReservationService {
    FlightService flightService;
    ReservationRepository reservationRepository;
    PassengerRepository passengerRepository;
    PDFGenerator pdfGenerator;
    EmailUtil emailUtil;

    public ReservationServiceImpl(FlightService flightService, ReservationRepository reservationRepository, PassengerRepository passengerRepository, PDFGenerator pdfGenerator, EmailUtil emailUtil) {
        this.flightService = flightService;
        this.reservationRepository = reservationRepository;
        this.passengerRepository = passengerRepository;
        this.pdfGenerator = pdfGenerator;
        this.emailUtil = emailUtil;
    }

    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {
        Long flightId = reservationRequest.getFlightId();
        Flight flight = flightService.getFlightById(flightId).orElseThrow(() -> new ResourceNotFoundException("Flight not found with id " + flightId));

        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);
        String filePath = "C:/Users/mukes/Desktop/reservationdetails/Reservation Details" + savedReservation.getId() + ".pdf";
        try {
            pdfGenerator.generateItinerary(savedReservation, filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        emailUtil.sendItinerary("mukesh@bluethink.in", filePath);
        return savedReservation;
    }
}
