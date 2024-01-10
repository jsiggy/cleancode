package com.siggy.training.code.smells.flight;

import com.siggy.training.code.smells.user.UserDetails;

import java.util.Date;

public class FlightBookingService {

    private final FlightTicketingService flightTicketingService = new FlightTicketingService();
    private final FlightSearchService flightSearchService = new FlightSearchService();

    boolean bookFlight(String airline, int flightNumber, String departureAirport, String arrivalAirport, Date departureDate,
                       UserDetails user, String creditCardNumber, String ccName, Date ccExpiration) {
        if (flightNumber < 0)
            throw new IllegalArgumentException("Flight number must be > 0");

        if (creditCardNumber == null || ccExpiration == null || ccName == null)
            throw new IllegalArgumentException("Invalid credit card information");

        departureAirport = departureAirport.trim();
        arrivalAirport = arrivalAirport.trim();
        creditCardNumber = creditCardNumber.trim();

        Flight flight = flightSearchService.findFlight(airline, flightNumber, departureAirport, arrivalAirport, departureDate);
        if (!flightSearchService.isFlightAvailable(flight))
            return false;
        if (flightTicketingService.purchaseFlight(flight, user, creditCardNumber, ccName, ccExpiration))
            return true;
        else
            return false;
    }
}
