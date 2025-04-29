package day7;

import java.util.Scanner;

public class ChatLoggerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Chat Logger Menu ===");
            System.out.println("1. Log a message");
            System.out.println("2. Search for a message");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter message to log: ");
                    String message = scanner.nextLine();
                    ChatLogger.logMessage(message);
                    break;
                case 2:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    ChatLogger.searchMessage(keyword);
                    break;
                case 3:
                    System.out.println("🚪 Exiting chat logger...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠ Invalid choice! Please try again.");
            }
        }
    }
}
