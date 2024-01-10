package com.siggy.training.code.smells.flight;

import java.util.Date;

public class FlightSearchService {
    public boolean isFlightAvailable(Flight flight) {
        return true;
    }

    public Flight findFlight(String airline, int flightNumber, String departureAirport, String arrivalAirport, Date departureDate) {
        return new Flight();
    }
}
