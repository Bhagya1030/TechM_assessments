package day6;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

enum OrderStatus {
    PENDING, SHIPPED, DELIVERED
}

class Order {
    private int orderID;
    private double amount;
    private LocalDateTime orderDate;
    private OrderStatus status;

    // Constructor
    public Order(int orderID, double amount, LocalDateTime orderDate, OrderStatus status) {
        this.orderID = orderID;
        this.amount = amount;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters
    public int getOrderID() { return orderID; }
    public double getAmount() { return amount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public OrderStatus getStatus() { return status; }

    // Format order date
    public String getFormattedOrderDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return orderDate.format(formatter);
    }

    // Display order details
    @Override
    public String toString() {
        return "Order #" + orderID +
               " | Amount: $" + amount +
               " | Date: " + getFormattedOrderDate() +
               " | Status: " + status;
    }
}

class OrderProcessingSystem {
    private List<Order> orders;

    public OrderProcessingSystem(List<Order> orders) {
        this.orders = orders;
    }

    // Calculate total revenue for today's orders
    public double getTotalRevenueForToday() {
        LocalDateTime today = LocalDateTime.now();
        return orders.stream()
                .filter(order -> order.getOrderDate().toLocalDate().equals(today.toLocalDate()))
                .mapToDouble(Order::getAmount)
                .sum();
    }

    // Get a list of all pending orders sorted by order date
    public List<Order> getPendingOrders() {
        return orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.PENDING)
                .sorted(Comparator.comparing(Order::getOrderDate))
                .collect(Collectors.toList());
    }

    // Find the most recent delivered order
    public Optional<Order> getMostRecentDeliveredOrder() {
        return orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.DELIVERED)
                .max(Comparator.comparing(Order::getOrderDate));
    }
}

// Main Class
public class OnlineShopping {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order(101, 150.50, LocalDateTime.now().minusHours(2), OrderStatus.PENDING),
            new Order(102, 200.75, LocalDateTime.now().minusDays(1), OrderStatus.SHIPPED),
            new Order(103, 300.00, LocalDateTime.now().minusHours(4), OrderStatus.PENDING),
            new Order(104, 450.25, LocalDateTime.now().minusDays(2), OrderStatus.DELIVERED),
            new Order(105, 120.99, LocalDateTime.now(), OrderStatus.DELIVERED),
            new Order(106, 500.00, LocalDateTime.now().minusDays(1), OrderStatus.PENDING)
        );

        OrderProcessingSystem orderSystem = new OrderProcessingSystem(orders);

        // Total revenue for today's orders
        System.out.println("\n💰 Total Revenue for Today: $" + orderSystem.getTotalRevenueForToday());

        // Pending orders sorted by date
        System.out.println("\n📦 Pending Orders:");
        List<Order> pendingOrders = orderSystem.getPendingOrders();
        if (pendingOrders.isEmpty()) {
            System.out.println("No pending orders.");
        } else {
            pendingOrders.forEach(System.out::println);
        }

        // Most recent delivered order
        System.out.println("\n🚚 Most Recent Delivered Order:");
        Optional<Order> recentDeliveredOrder = orderSystem.getMostRecentDeliveredOrder();
        System.out.println(recentDeliveredOrder.map(Order::toString).orElse("No delivered orders found."));
    }
}
