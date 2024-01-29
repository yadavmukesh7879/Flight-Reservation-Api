package com.api.flightreservation.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class FindFlightDto {
    @NotBlank(message = "Please enter Departure City")
    private String departureCity;
    @NotBlank(message = "Please enter Arrival City")
    private String arrivalCity;
    @NotNull(message = "Please enter Departure Date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateOfDeparture;
}
