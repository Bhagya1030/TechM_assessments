package day5;
import java.util.*;

// Generic Multi-Language Dictionary
class MultiLanguageDictionary<T extends String, U extends String> {
    private TreeMap<T, U> dictionary;

    // Constructor
    public MultiLanguageDictionary() {
        this.dictionary = new TreeMap<>();
    }

    // Generic method to add words and meanings
    public void addWord(T word, U meaning) {
        dictionary.put(word, meaning);
    }

    // Display dictionary sorted alphabetically
    public void displayDictionary() {
        System.out.println("\nDictionary (Alphabetically Sorted):");
        for (Map.Entry<T, U> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Sort words by length using a Comparator
    public void displaySortedByLength() {
        List<T> sortedKeys = new ArrayList<>(dictionary.keySet());
        sortedKeys.sort(Comparator.comparingInt(String::length));

        System.out.println("\nDictionary (Sorted by Word Length):");
        for (T key : sortedKeys) {
            System.out.println(key + " -> " + dictionary.get(key));
        }
    }
}

// Main Class
public class MultiLanDictApp {
    public static void main(String[] args) {
        // Create a dictionary instance
        MultiLanguageDictionary<String, String> dictionary = new MultiLanguageDictionary<>();

        // Add words and meanings
        dictionary.addWord("Hola", "Hello (Spanish)");
        dictionary.addWord("Bonjour", "Hello (French)");
        dictionary.addWord("Ciao", "Hello (Italian)");
        dictionary.addWord("Namaste", "Hello (Hindi)");
        dictionary.addWord("Konnichiwa", "Hello (Japanese)");

        // Display dictionary sorted alphabetically
        dictionary.displayDictionary();

        // Display dictionary sorted by word length
        dictionary.displaySortedByLength();
    }
}
