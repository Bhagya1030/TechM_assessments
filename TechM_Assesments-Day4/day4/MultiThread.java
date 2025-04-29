package day4;

import java.util.Random;

// Custom exception for negative numbers
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

// Runnable for generating random numbers
class NumberGenerator implements Runnable {
    private final int[] numbers;
    private final Random random = new Random();

    public NumberGenerator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        System.out.println("NumberGenerator: Generating numbers...");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(50) - 10; // Some numbers may be negative
            System.out.println("Generated: " + numbers[i]);
            try {
                Thread.sleep(100); // Simulate processing delay
            } catch (InterruptedException e) {
                System.out.println("NumberGenerator interrupted.");
            }
        }
    }
}

// Runnable for calculating square roots
class SquareRootCalculator implements Runnable {
    private final int[] numbers;

    public SquareRootCalculator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        System.out.println("SquareRootCalculator: Calculating square roots...");
        for (int num : numbers) {
            try {
                if (num < 0) {
                    throw new NegativeNumberException("Error: Negative number encountered: " + num);
                }
                System.out.println("Square root of " + num + " is " + Math.sqrt(num));
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    Thread.sleep(100); // Simulate processing delay
                } catch (InterruptedException e) {
                    System.out.println("SquareRootCalculator interrupted.");
                }
            }
        }
    }
}

public class MultiThread {
    public static void main(String[] args) {
        int[] numbers = new int[10]; // Shared array

        // Creating threads
        Thread generatorThread = new Thread(new NumberGenerator(numbers));
        Thread calculatorThread = new Thread(new SquareRootCalculator(numbers));

        try {
            generatorThread.start();
            generatorThread.join(); // Ensure numbers are generated before calculating

            calculatorThread.start();
            calculatorThread.join(); // Wait for calculations to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        } finally {
            System.out.println("Execution completed. All threads closed.");
        }
    }
}
