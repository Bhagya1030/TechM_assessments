import java.sql.*;

public class Order{
    public void addOrder(int id, String product, double price, String status) {
        String sql = "INSERT INTO orders (id, product, price, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, product);
            stmt.setDouble(3, price);
            stmt.setString(4, status);
            stmt.executeUpdate();
            System.out.println("Order added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("id"));
                System.out.println("Product: " + rs.getString("product"));
                System.out.println("Price: $" + rs.getDouble("price"));
                System.out.println("Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderStatus(int id, String status) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Order status updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCanceledOrders() {
        String sql = "DELETE FROM orders WHERE status = 'Canceled'";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsDeleted = stmt.executeUpdate(sql);
            System.out.println(rowsDeleted + " canceled orders deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

