import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final CountDownLatch latch;
    private final int taskId;

    public Task(CountDownLatch latch, int taskId) {
        this.latch = latch;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + taskId + " started.");
            Thread.sleep(1000 + (taskId * 500));
            System.out.println("Task " + taskId + " completed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}

public class Countdown {
    public static void main(String[] args) {
        final int numTasks = 5;
        CountDownLatch latch = new CountDownLatch(numTasks);
        ExecutorService executor = Executors.newFixedThreadPool(numTasks);

        for (int i = 1; i <= numTasks; i++) {
            executor.execute(new Task(latch, i));
        }

        try {
            latch.await(); 
            System.out.println("All tasks finished. Merging results...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
        System.out.println("Processing complete.");
    }
}
