package com.api.flightreservation.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class FindFlight {

    private String departureCity;
    private String arrivalCity;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateOfDeparture;
}
