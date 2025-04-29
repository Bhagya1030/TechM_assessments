package day5;
import java.util.*;

// Passenger class
class Passenger {
    String name;
    String ticketClass; // Business, Economy, General
    long bookingTime; // Timestamp to track booking order

    // Constructor
    public Passenger(String name, String ticketClass, long bookingTime) {
        this.name = name;
        this.ticketClass = ticketClass;
        this.bookingTime = bookingTime;
    }

    // Display Passenger details
    public String toString() {
        return "Passenger: " + name + " | Class: " + ticketClass + " | Booking Time: " + bookingTime;
    }
}

// Comparator for PriorityQueue
class PassengerComparator implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        // Priority Order: Business > Economy > General
        Map<String, Integer> priorityMap = Map.of(
            "Business", 3,
            "Economy", 2,
            "General", 1
        );

        int priority1 = priorityMap.get(p1.ticketClass);
        int priority2 = priorityMap.get(p2.ticketClass);

        // Compare ticket classes (higher priority first)
        if (priority1 != priority2) {
            return Integer.compare(priority2, priority1); // Descending order
        }

        // If same class, compare booking times (earlier first)
        return Long.compare(p1.bookingTime, p2.bookingTime);
    }
}

// Main class
public class FlightBookingSystem {
    public static void main(String[] args) {
        // PriorityQueue with custom Comparator
        PriorityQueue<Passenger> bookingQueue = new PriorityQueue<>(new PassengerComparator());

        // Simulate passenger bookings
        bookingQueue.add(new Passenger("Alice", "Economy", System.currentTimeMillis()));
        bookingQueue.add(new Passenger("Bob", "Business", System.currentTimeMillis() - 5000));
        bookingQueue.add(new Passenger("Charlie", "General", System.currentTimeMillis() - 2000));
        bookingQueue.add(new Passenger("David", "Economy", System.currentTimeMillis() - 1000));
        bookingQueue.add(new Passenger("Eve", "Business", System.currentTimeMillis() - 7000));

        // Display all passengers in priority order
        System.out.println("Passengers in Booking Order:");
        Iterator<Passenger> iterator = bookingQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Process bookings in priority order
        System.out.println("\nProcessing Bookings:");
        while (!bookingQueue.isEmpty()) {
            System.out.println("Booking Confirmed -> " + bookingQueue.poll());
        }
    }
}
