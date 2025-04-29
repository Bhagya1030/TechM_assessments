package day2;

public class Employee {
	protected double baseSalary = 50000; // Base salary for all employees

    // Method to calculate salary (to be overridden)
    public double calculateSalary() {
        return baseSalary;
    }
}
