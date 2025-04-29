package day1;
import java.util.*;
public class atmwithdraw {
	public static void withdrawCash(int amount) {
        if (amount % 100 != 0) {
            System.out.println("Error: Amount must be a multiple of 100.");
            return;
        }
        int notes2000 = amount / 2000;
        amount %= 2000;
        int notes500 = amount / 500;
        amount %= 500;
        int notes100 = amount / 100;
        System.out.println("Cash Dispensed:");
        if (notes2000 > 0) System.out.println(notes2000 + " x ₹2000");
        if (notes500 > 0) System.out.println(notes500 + " x ₹500");
        if (notes100 > 0) System.out.println(notes100 + " x ₹100");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        int amount = scanner.nextInt();
        scanner.close();
        withdrawCash(amount);
    }
}