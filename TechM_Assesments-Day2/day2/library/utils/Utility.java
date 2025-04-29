package day2.library.utils;
import java.util.UUID;

public class Utility {
    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 8); // Generates a short unique ID
    }
}