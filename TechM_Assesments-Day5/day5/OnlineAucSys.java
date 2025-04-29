package day5;
import java.util.*;

// Bid class representing a bid in the auction
class Bid {
    private String bidderName;
    private double amount;
    private long bidTime;

    // Constructor
    public Bid(String bidderName, double amount, long bidTime) {
        this.bidderName = bidderName;
        this.amount = amount;
        this.bidTime = bidTime;
    }

    public double getAmount() {
        return amount;
    }

    public long getBidTime() {
        return bidTime;
    }

    @Override
    public String toString() {
        return "Bidder: " + bidderName + ", Amount: $" + amount + ", Time: " + bidTime;
    }
}

// Comparator to prioritize bids (highest amount first, earliest time in case of tie)
class BidComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid b1, Bid b2) {
        if (b1.getAmount() != b2.getAmount()) {
            return Double.compare(b2.getAmount(), b1.getAmount()); // Highest bid first
        }
        return Long.compare(b1.getBidTime(), b2.getBidTime()); // Earlier bid wins in case of tie
    }
}

// Generic Auction class
class Auction<T> {
    private T item;
    private PriorityQueue<Bid> bidQueue;

    // Constructor
    public Auction(T item) {
        this.item = item;
        this.bidQueue = new PriorityQueue<>(new BidComparator());
    }

    // Method to place a bid
    public void placeBid(String bidderName, double amount) {
        long bidTime = System.currentTimeMillis();
        bidQueue.add(new Bid(bidderName, amount, bidTime));
        System.out.println("Bid placed: " + bidderName + " - $" + amount);
    }

    // Process and remove the highest bid
    public void processHighestBid() {
        if (!bidQueue.isEmpty()) {
            Bid highestBid = bidQueue.poll();
            System.out.println("\nHighest Bid Processed: " + highestBid);
        } else {
            System.out.println("\nNo bids to process!");
        }
    }

    // Display all bids
    public void displayBids() {
        if (bidQueue.isEmpty()) {
            System.out.println("\nNo bids available.");
        } else {
            System.out.println("\nAll Bids in Priority Order:");
            for (Bid bid : bidQueue) {
                System.out.println(bid);
            }
        }
    }
}

// Main Class
public class OnlineAucSys {
    public static void main(String[] args) {
        // Create an auction for an item
        Auction<String> auction = new Auction<>("Antique Painting");

        // Place some bids
        auction.placeBid("Alice", 500);
        auction.placeBid("Bob", 700);
        auction.placeBid("Charlie", 700); // Tie case (earlier bid wins)
        auction.placeBid("David", 600);

        // Display all bids
        auction.displayBids();

        // Process the highest bid
        auction.processHighestBid();

        // Display remaining bids after processing
        auction.displayBids();
    }
}
