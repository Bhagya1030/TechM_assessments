package day1;
import java.util.*;
public class fib {
	 public static void generateFibonacci(int n) {
	        int first = 0, second = 1, count = 0;
	        do {
	            System.out.print(first + (count < n - 1 ? ", " : "")); // Print number
	            int next = first + second;
	            first = second;
	            second = next;
	            count++;
	        } while (count < n);
	    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            generateFibonacci(n);
        }
    }
}
