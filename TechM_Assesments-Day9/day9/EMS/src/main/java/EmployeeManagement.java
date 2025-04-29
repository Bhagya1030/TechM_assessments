import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    employeeDAO.addEmployee(name, email, salary);
                    break;

                case 2:
                    System.out.print("Enter name or email to search: ");
                    String keyword = scanner.nextLine();
                    List<String> results = employeeDAO.searchEmployee(keyword);
                    results.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update salary: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    employeeDAO.updateSalary(id, newSalary);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
