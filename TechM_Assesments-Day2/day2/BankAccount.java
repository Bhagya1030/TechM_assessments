package day2;

public class BankAccount {
	private double balance;
    private String ownerName;

    // Default constructor
    public BankAccount() {
        this(0, "Unknown"); // Calls the third constructor with default values
    }

    // Constructor with balance
    public BankAccount(double balance) {
        this(balance, "Unknown"); // Calls the third constructor with a default owner name
    }

    // Constructor with balance and owner name
    public BankAccount(double balance, String ownerName) {
        this.balance = balance;
        this.ownerName = ownerName;
    }

    // Method to display account details
    public void displayAccountInfo() {
        System.out.println("Owner: " + ownerName + ", Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount(1000);
        BankAccount acc3 = new BankAccount(5000, "John Doe");

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
    }
}
