package day7;

import java.io.*;
import java.nio.file.*;

public class ChatLogger {
    private static final String LOG_FILE = "chat_logs.txt";
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB

    // Append message to log file
    public static void logMessage(String message) {
        try {
            rotateLogsIfNeeded();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                writer.write(message);
                writer.newLine();
                System.out.println("✅ Message logged: " + message);
            }
        } catch (IOException e) {
            System.err.println("⚠ Error writing to log file: " + e.getMessage());
        }
    }

    // Search messages in the log file
    public static void searchMessage(String keyword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println("🔍 Found: " + line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("❌ No messages found with keyword: " + keyword);
            }
        } catch (IOException e) {
            System.err.println("⚠ Error reading log file: " + e.getMessage());
        }
    }

    // Check if log rotation is needed and create a new log file if necessary
    private static void rotateLogsIfNeeded() {
        File logFile = new File(LOG_FILE);
        if (logFile.exists() && logFile.length() > MAX_FILE_SIZE) {
            int index = 1;
            File newFile;
            do {
                newFile = new File("chat_logs_" + index + ".txt");
                index++;
            } while (newFile.exists());

            logFile.renameTo(newFile);
            System.out.println("🔄 Log file rotated: " + newFile.getName());
        }
    }
}
