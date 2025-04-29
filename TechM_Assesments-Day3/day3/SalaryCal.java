package day2;

public class SalaryCal {
	 public static void main(String[] args) {
	        Employee emp = new Employee();
	        Manager mgr = new Manager();

	        // Display salaries
	        System.out.println("Employee Salary: Rs. " + emp.calculateSalary()); // Base salary: 50000
	        System.out.println("Manager Salary: Rs. " + mgr.calculateSalary()); // Base salary + Bonus
	    }
}
