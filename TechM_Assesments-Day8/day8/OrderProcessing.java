import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class OrderProcessor implements Runnable {
    private final BlockingQueue<String> orderQueue;
    private volatile boolean running = true;

    public OrderProcessor(BlockingQueue<String> queue) {
        this.orderQueue = queue;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running || !orderQueue.isEmpty()) {
            try {
                String order = orderQueue.take();
                System.out.println("Processing order: " + order);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class OrderProcessing {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> orderQueue = new LinkedBlockingQueue<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        OrderProcessor processor = new OrderProcessor(orderQueue);
        executor.submit(processor);

        for (int i = 1; i <= 10; i++) {
            orderQueue.put("Order " + i);
        }

        Thread.sleep(3000);
        processor.stop();
        executor.shutdown();
    }
}
