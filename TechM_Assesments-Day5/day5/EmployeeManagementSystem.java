package day5;
import java.util.*;

// Employee class implementing Comparable
class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    // Override equals() & hashCode() to prevent duplicates in HashSet
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id; // Uniqueness based on ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" + "ID=" + id + ", Name='" + name + "', Salary=" + salary + ", Dept='" + department + "'}";
    }
}

// Comparator for sorting by Salary
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

// Comparator for sorting by Name
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

// Employee Management System
public class EmployeeManagementSystem {
    private List<Employee> employeeList = new ArrayList<>();
    private Set<Employee> employeeSet = new HashSet<>();
    private Map<String, List<Employee>> departmentMap = new HashMap<>();

    // Add Employee
    public void addEmployee(Employee emp) {
        if (employeeSet.add(emp)) { // HashSet ensures uniqueness
            employeeList.add(emp);

            // Add employee to department map
            departmentMap.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        } else {
            System.out.println("Duplicate Employee (ID: " + emp.getId() + ") - Not Added.");
        }
    }

    // Display Employees
    public void displayEmployees() {
        System.out.println("\nAll Employees:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    // Sort Employees by Salary
    public void sortBySalary() {
        employeeList.sort(new SalaryComparator());
        System.out.println("\nEmployees Sorted by Salary:");
        displayEmployees();
    }

    // Sort Employees by Name
    public void sortByName() {
        employeeList.sort(new NameComparator());
        System.out.println("\nEmployees Sorted by Name:");
        displayEmployees();
    }

    // Find Employee by ID
    public Employee findEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Display Employees by Department
    public void displayEmployeesByDepartment() {
        System.out.println("\nEmployees Grouped by Department:");
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (Employee emp : entry.getValue()) {
                System.out.println("  " + emp);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Adding employees
        ems.addEmployee(new Employee(101, "Alice", 70000, "IT"));
        ems.addEmployee(new Employee(102, "Bob", 60000, "HR"));
        ems.addEmployee(new Employee(103, "Charlie", 50000, "Finance"));
        ems.addEmployee(new Employee(104, "David", 80000, "IT"));
        ems.addEmployee(new Employee(105, "Eve", 55000, "Finance"));
        ems.addEmployee(new Employee(101, "Alice", 70000, "IT")); // Duplicate ID (should not be added)

        // Display all employees
        ems.displayEmployees();

        // Sort by salary
        ems.sortBySalary();

        // Sort by name
        ems.sortByName();

        // Search by ID
        int searchId = 103;
        Employee found = ems.findEmployeeById(searchId);
        System.out.println("\nSearch Result for Employee ID " + searchId + ": " + (found != null ? found : "Not Found"));

        // Display employees by department
        ems.displayEmployeesByDepartment();
    }
}
