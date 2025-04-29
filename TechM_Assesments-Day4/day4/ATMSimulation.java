package day4;
import java.util.Random;
import java.util.Scanner;

// Custom exception for network issues
class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}

// Custom exception for incorrect PIN
class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

// Custom exception for insufficient balance
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom exception for exceeding daily limit
class DailyLimitExceededException extends Exception {
    public DailyLimitExceededException(String message) {
        super(message);
    }
}

public class ATMSimulation {
    private static final int CORRECT_PIN = 1234; // Example PIN
    private static double balance = 5000.00; // User's bank balance
    private static final double DAILY_LIMIT = 2000.00; // Daily withdrawal limit

    // Method to simulate network check
    private static void checkNetwork() throws NetworkException {
        Random random = new Random();
        boolean networkDown = random.nextInt(10) < 2; // 20% chance of network failure
        if (networkDown) {
            throw new NetworkException("Network error: Unable to connect to the bank servers.");
        }
    }

    // Method to process ATM withdrawal
    private static void withdrawMoney(int pin, double amount) 
            throws InvalidPINException, InsufficientFundsException, DailyLimitExceededException {
        
        // Check if PIN is correct
        if (pin != CORRECT_PIN) {
            throw new InvalidPINException("Error: Incorrect PIN entered.");
        }
        
        // Check if withdrawal amount exceeds balance
        if (amount > balance) {
            throw new InsufficientFundsException("Error: Insufficient balance. Available balance: $" + balance);
        }
        
        // Check if withdrawal exceeds daily limit
        if (amount > DAILY_LIMIT) {
            throw new DailyLimitExceededException("Error: Withdrawal exceeds daily limit of $" + DAILY_LIMIT);
        }

        // Process withdrawal
        balance -= amount;
        System.out.println("Transaction Successful! New Balance: $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Outer try block - checking network
            checkNetwork();
            System.out.println("Network connected successfully.");

            try {
                // Inner try block - ATM withdrawal process
                System.out.print("Enter PIN: ");
                int pin = scanner.nextInt();

                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();

                withdrawMoney(pin, amount);
            } catch (InvalidPINException e) {
                System.out.println(e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            } catch (DailyLimitExceededException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Thank you for using the ATM.");
            }

        } catch (NetworkException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close(); // Close scanner to avoid memory leaks
        }
    }
}
