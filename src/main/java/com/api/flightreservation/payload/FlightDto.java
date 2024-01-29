package com.api.flightreservation.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class FlightDto {
    private Long id;
    @NotBlank(message = "Please enter flight number")
    private String flightNumber;
    @NotBlank(message = "Please enter operating airlines")
    private String operatingAirLines;
    @NotBlank(message = "Please enter departure city")
    private String departureCity;
    @NotBlank(message = "Please enter arrival city")
    private String arrivalCity;
    @NotNull(message = "Please enter date of departure")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfDeparture;
    @NotNull(message = "Please enter estimated departure time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Timestamp estimatedDepartureTime;
}
