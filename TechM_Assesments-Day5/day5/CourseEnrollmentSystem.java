package day5;
import java.util.*;

// Course class
class Course implements Comparable<Course> {
    String courseName;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
    }

    // Display Course
    @Override
    public String toString() {
        return courseName;
    }

    // Compare courses alphabetically
    @Override
    public int compareTo(Course other) {
        return this.courseName.compareToIgnoreCase(other.courseName);
    }
}

// Main class
public class CourseEnrollmentSystem {
    public static void main(String[] args) {
        // LinkedList to store enrolled courses
        LinkedList<Course> courses = new LinkedList<>();

        // Adding courses
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Physics"));
        courses.add(new Course("Computer Science"));
        courses.add(new Course("Biology"));
        courses.add(new Course("English Literature"));

        // Display all courses before sorting
        System.out.println("Enrolled Courses (Unsorted): " + courses);

        // Sorting courses alphabetically
        Collections.sort(courses);
        System.out.println("Enrolled Courses (Sorted): " + courses);

        // Using ListIterator to navigate courses
        ListIterator<Course> listIterator = courses.listIterator();

        System.out.println("\nNavigating Courses (Forward):");
        while (listIterator.hasNext()) {
            System.out.println("-> " + listIterator.next());
        }

        System.out.println("\nNavigating Courses (Backward):");
        while (listIterator.hasPrevious()) {
            System.out.println("<- " + listIterator.previous());
        }

        // Removing a course
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.courseName.equalsIgnoreCase("Biology")) {
                iterator.remove(); // Remove Biology course
                System.out.println("\nCourse Removed: " + course);
            }
        }

        // Display courses after removal
        System.out.println("Updated Enrolled Courses: " + courses);
    }
}
