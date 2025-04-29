package day7;
import java.io.*;
import java.util.*;

public class EmployeeDatabase {
    private static final String FILE_NAME = "employees.dat";
    private List<Employee> employees;

    public EmployeeDatabase() {
        employees = loadEmployees();
    }

    private List<Employee> loadEmployees() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ Error loading employees: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void saveEmployees() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("⚠ Error saving employees: " + e.getMessage());
        }
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        saveEmployees();
        System.out.println("✅ Employee added successfully!");
    }

    public Employee searchEmployee(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateSalary(int id, double newSalary) {
        Employee emp = searchEmployee(id);
        if (emp != null) {
            emp.setSalary(newSalary);
            saveEmployees();
            System.out.println("✅ Salary updated!");
        } else {
            System.out.println("❌ Employee not found.");
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
        saveEmployees();
        System.out.println("✅ Employee deleted!");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("📂 No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }
}
