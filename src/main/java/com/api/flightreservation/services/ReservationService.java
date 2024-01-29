package com.api.flightreservation.services;

import com.api.flightreservation.dto.ReservationRequest;
import com.api.flightreservation.entities.Reservation;

public interface ReservationService {
    public Reservation bookFlight(ReservationRequest reservationRequest);
}
