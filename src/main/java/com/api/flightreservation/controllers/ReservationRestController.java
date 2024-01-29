package com.api.flightreservation.controllers;
import com.api.flightreservation.dto.UpdateReservationRequest;
import com.api.flightreservation.entities.Reservation;
import com.api.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {
    @Autowired
    ReservationRepository reservationRepository;
    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> findReservation(@PathVariable Long id){
        Reservation reservation = reservationRepository.findById(id).get();
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }
    @PostMapping("/reservations")
    public Reservation updateReservations(@RequestBody UpdateReservationRequest request){
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckIn(request.getCheckedIn());
        Reservation reservation1 =  reservationRepository.save(reservation);
        return reservation1;
    }
}
