import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Flight {
    private final String flightNumber;
    private int availableSeats;

    public Flight(String flightNumber, int seats) {
        this.flightNumber = flightNumber;
        this.availableSeats = seats;
    }

    public synchronized boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

class FlightSearch implements Callable<List<Flight>> {
    private final List<Flight> flights;

    public FlightSearch(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> call() throws Exception {
        Thread.sleep(1000); 
        return flights;
    }
}

public class FlightBooking {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AI101", 5));
        flights.add(new Flight("BA202", 3));
        flights.add(new Flight("QF303", 2));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<List<Flight>> futureFlights = executor.submit(new FlightSearch(flights));

        List<Flight> availableFlights = futureFlights.get();
        System.out.println("Available Flights:");
        for (Flight flight : availableFlights) {
            System.out.println("Flight: " + flight.getFlightNumber() + ", Seats: " + flight.getAvailableSeats());
        }

        Runnable bookingTask = () -> {
            Flight flight = availableFlights.get(0);
            synchronized (flight) {
                if (flight.bookSeat()) {
                    System.out.println(Thread.currentThread().getName() + " booked a seat on " + flight.getFlightNumber());
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to book a seat.");
                }
            }
        };

        for (int i = 0; i < 6; i++) {
            executor.execute(bookingTask);
        }

        executor.shutdown();
    }
}
