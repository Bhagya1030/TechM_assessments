package day5;
import java.util.*;

public class StudentExmResAnaly {
    public static void main(String[] args) {
        // Step 1: Store student scores in a HashMap
        HashMap<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 92);
        studentScores.put("Charlie", 78);
        studentScores.put("David", 88);
        studentScores.put("Eve", 95);

        // Step 2: Convert HashMap to TreeMap (sorted by student name)
        TreeMap<String, Integer> sortedScores = new TreeMap<>(studentScores);
        System.out.println("Sorted Student Scores: " + sortedScores);

        // Step 3: Find the highest and lowest scores
        int highestScore = Collections.max(studentScores.values());
        int lowestScore = Collections.min(studentScores.values());

        System.out.println("\nHighest Score: " + highestScore);
        System.out.println("Lowest Score: " + lowestScore);

        // Step 4: Use Arrays.asList() to process test scores
        List<Integer> scoresList = Arrays.asList(85, 92, 78, 88, 95);
        int sum = scoresList.stream().mapToInt(Integer::intValue).sum();
        double average = sum / (double) scoresList.size();

        System.out.println("\nAll Scores: " + scoresList);
        System.out.println("Total Sum: " + sum);
        System.out.println("Average Score: " + average);
    }
}
