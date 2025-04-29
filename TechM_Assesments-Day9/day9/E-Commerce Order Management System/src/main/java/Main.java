public class Main {
    public static void main(String[] args) {
        Order orderDAO = new Order();

        // 1. Add a new order
        orderDAO.addOrder(101, "Laptop", 1200.50, "Pending");

        // 2. Retrieve order details by ID
        orderDAO.getOrderById(101);

        // 3. Update order status
        orderDAO.updateOrderStatus(101, "Shipped");

        // 4. Delete canceled orders
        orderDAO.deleteCanceledOrders();
    }
}
