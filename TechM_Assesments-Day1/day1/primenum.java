package day1;
import java.util.*;
public class primenum {
	 public static boolean isPrime(int num) {
	        if (num < 2) return false;
	        for (int i = 2; i * i <= num; i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true; 
	    }
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int num = scanner.nextInt();
	        scanner.close();
	        if (isPrime(num)) {
	            System.out.println("Yes, " + num + " is a prime number.");
	        } else {
	            System.out.println("No, " + num + " is not a prime number.");
	        }
	    }
}