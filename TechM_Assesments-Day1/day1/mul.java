package day1;
import java.util.*;
public class mul {
	public static void printTableForLoop(int n) {
        System.out.println("\nMultiplication Table (For Loop) for " + n);
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
    public static void printTableWhileLoop(int n, int start, int end) {
        System.out.println("\nMultiplication Table (While Loop) for " + n + " from " + start + " to " + end);
        int i = start;
        while (i <= end) {
            System.out.println(n + " x " + i + " = " + (n * i));
            i++;
        }
    }
    public static void printTableReverseForLoop(int n) {
        System.out.println("\nMultiplication Table in Reverse Order (For Loop) for " + n);
        for (int i = 10; i >= 1; i--) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            System.out.print("\nEnter a number for multiplication table: ");
            int n = scanner.nextInt();
            printTableForLoop(n);
            printTableReverseForLoop(n);
            System.out.print("\nEnter start range: ");
            int start = scanner.nextInt();
            System.out.print("Enter end range: ");
            int end = scanner.nextInt();
            printTableWhileLoop(n, start, end);
            System.out.print("\nDo you want to generate another table? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
        scanner.close();
        System.out.println("Thank you! Program exited.");
    }
}
