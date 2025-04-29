package day7.filebackup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BackupManager backupManager = new BackupManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📂 File Backup and Recovery System");
            System.out.println("1️⃣ Backup Directory");
            System.out.println("2️⃣ Recover Files");
            System.out.println("3️⃣ View Backup Metadata");
            System.out.println("4️⃣ Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter directory to backup: ");
                    String dir = scanner.nextLine();
                    backupManager.backupDirectory(dir);
                    break;
                case 2:
                    backupManager.recoverFiles();
                    break;
                case 3:
                    backupManager.showBackupMetadata();
                    break;
                case 4:
                    System.out.println("👋 Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("⚠ Invalid choice! Try again.");
            }
        }
    }
}
