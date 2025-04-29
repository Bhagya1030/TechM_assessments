package day2;

import java.util.*;

public class StudentSorting {
	 public static void main(String[] args) {
	        // Creating a list of students
	        List<Student> students = Arrays.asList(
	            new Student("Alice", 85),
	            new Student("Bob", 90),
	            new Student("Charlie", 78)
	        );

	        // Sorting using an anonymous inner class
	        Collections.sort(students, new Comparator<Student>() {
	            @Override
	            public int compare(Student s1, Student s2) {
	                return Integer.compare(s2.getMarks(), s1.getMarks()); // Descending order
	            }
	        });

	        // Display sorted list
	        for (Student s : students) {
	            System.out.println(s);
	        }
	    }
}
