package day2;

public class Payment {
    
    // Method 1: Pay using the default method
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Default Payment Method.");
    }
    // Method 2: Pay using a specific method
    public void pay(double amount, String method) {
        System.out.println("Paid Rs. " + amount + " using " + method + ".");
    }
    // Method 3: Pay using EMI with duration
    public void pay(double amount, String method, int emiMonths) {
        double emiAmount = amount / emiMonths;
        System.out.println("Paid Rs. " + amount + " using " + method + " in " + emiMonths +
                " months EMI (Rs. " + emiAmount + " per month).");
    }
    // Main method to demonstrate different ways to pay
    public static void main(String[] args) {
        Payment p = new Payment();
        
        p.pay(1000); // Default payment
        p.pay(2000, "Credit Card"); // Payment via Credit Card
        p.pay(5000, "UPI", 12); // Payment via UPI with EMI
    }
}