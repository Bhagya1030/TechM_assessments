package day2;

public class Manager extends Employee{
	private double bonus = 10000; // Additional bonus for managers

    // Overriding calculateSalary() method to add bonus
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}