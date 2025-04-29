package day6;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Flight {
    private String flightNumber;
    private LocalDateTime departureTime;
    private int duration; // in minutes
    private double price;
    private String destination;

    // Constructor
    public Flight(String flightNumber, LocalDateTime departureTime, int duration, double price, String destination) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.duration = duration;
        this.price = price;
        this.destination = destination;
    }

    // Getters
    public String getFlightNumber() { return flightNumber; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public int getDuration() { return duration; }
    public double getPrice() { return price; }
    public String getDestination() { return destination; }

    // Format departure time
    public String getFormattedDepartureTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm a");
        return departureTime.format(formatter);
    }

    // Display flight details
    @Override
    public String toString() {
        return "Flight " + flightNumber + " to " + destination +
               " | Departure: " + getFormattedDepartureTime() +
               " | Duration: " + duration + " min | Price: $" + price;
    }
}

class FlightBookingSystem {
    private List<Flight> flights;

    public FlightBookingSystem(List<Flight> flights) {
        this.flights = flights;
    }

    // Find flights departing within the next 6 hours
    public List<Flight> getFlightsWithinNext6Hours() {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getDepartureTime().isAfter(now) &&
                                  flight.getDepartureTime().isBefore(now.plusHours(6)))
                .collect(Collectors.toList());
    }

    // Find the cheapest flight for a given destination
    public Optional<Flight> getCheapestFlight(String destination) {
        return flights.stream()
                .filter(flight -> flight.getDestination().equalsIgnoreCase(destination))
                .min(Comparator.comparingDouble(Flight::getPrice));
    }

    // Find the fastest flight (shortest duration)
    public Optional<Flight> getFastestFlight() {
        return flights.stream()
                .min(Comparator.comparingInt(Flight::getDuration));
    }
}

// Main Class
public class FlightBookApp {
    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(
            new Flight("AI101", LocalDateTime.now().plusHours(2), 180, 450.00, "New York"),
            new Flight("BA202", LocalDateTime.now().plusHours(5), 150, 400.00, "London"),
            new Flight("EK303", LocalDateTime.now().plusHours(7), 200, 500.00, "Dubai"),
            new Flight("QF404", LocalDateTime.now().plusHours(3), 140, 380.00, "Sydney"),
            new Flight("LH505", LocalDateTime.now().plusHours(1), 220, 350.00, "Berlin")
        );

        FlightBookingSystem bookingSystem = new FlightBookingSystem(flights);

        // Flights departing in the next 6 hours
        System.out.println("\n🛫 Flights Departing in the Next 6 Hours:");
        List<Flight> upcomingFlights = bookingSystem.getFlightsWithinNext6Hours();
        if (upcomingFlights.isEmpty()) {
            System.out.println("No flights departing within the next 6 hours.");
        } else {
            upcomingFlights.forEach(System.out::println);
        }

        // Cheapest flight to New York
        String searchDestination = "New York";
        Optional<Flight> cheapestFlight = bookingSystem.getCheapestFlight(searchDestination);
        System.out.println("\n💰 Cheapest Flight to " + searchDestination + ":");
        System.out.println(cheapestFlight.map(Flight::toString).orElse("No flights available to " + searchDestination));

        // Fastest flight
        Optional<Flight> fastestFlight = bookingSystem.getFastestFlight();
        System.out.println("\n⏳ Fastest Flight:");
        System.out.println(fastestFlight.map(Flight::toString).orElse("No flights available!"));
    }
}
