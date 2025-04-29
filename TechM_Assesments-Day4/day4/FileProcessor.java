package day4;

import java.io.*;
//import java.util.*;

// Custom Exception: EmptyFileException
class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class FileProcessor {
    public static void main(String[] args) {
        String filePath = "C:\\dsa\\numbers.txt"; // Change this to your file path
        
        try {
            int sum = processFile(filePath);
            System.out.println("Sum of numbers: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format - " + e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred - " + e.getMessage());
        }
    }

    public static int processFile(String filePath) throws IOException, EmptyFileException {
        int sum = 0;
        boolean isEmpty = true;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    isEmpty = false;
                    sum += Integer.parseInt(line); // May throw NumberFormatException
                }
            }
        }
        
        if (isEmpty) {
            throw new EmptyFileException("The file is empty.");
        }
        
        return sum;
    }
}
