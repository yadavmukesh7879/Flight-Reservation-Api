package com.api.flightreservation.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@ToString
public class Flight extends AbstractEntity {

    private String flightNumber;

    private String operatingAirLines;

    private String departureCity;

    private String arrivalCity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfDeparture;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Timestamp estimatedDepartureTime;
}
