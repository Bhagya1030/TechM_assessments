import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Add new employee securely
    public void addEmployee(String name, String email, double salary) {
        String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search employee by name or email securely
    public List<String> searchEmployee(String keyword) {
        String sql = "SELECT * FROM employees WHERE name LIKE ? OR email LIKE ?";
        List<String> results = new ArrayList<>();
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                results.add("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + 
                            ", Email: " + rs.getString("email") + ", Salary: $" + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    // Update employee salary securely
    public void updateSalary(int id, double newSalary) {
        String sql = "UPDATE employees SET salary=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setDouble(1, newSalary);
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " record(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
