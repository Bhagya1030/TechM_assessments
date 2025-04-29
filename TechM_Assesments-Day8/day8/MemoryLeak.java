import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryLeak {
    private static List<byte[]> memoryLeakList = new ArrayList<>();
    private static Map<Integer, WeakReference<byte[]>> weakCache = new HashMap<>();

    public static void main(String[] args) {
        simulateMemoryLeak();
        monitorMemoryUsage();
        fixMemoryLeak();
        monitorMemoryUsage();
    }

    private static void simulateMemoryLeak() {
        System.out.println("Simulating memory leak...");
        for (int i = 0; i < 100; i++) {
            byte[] leak = new byte[1024 * 1024];
            memoryLeakList.add(leak);
        }
    }

    private static void monitorMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total Memory: " + runtime.totalMemory());
        System.out.println("Free Memory: " + runtime.freeMemory());
    }

    private static void fixMemoryLeak() {
        System.out.println("Fixing memory leak...");
        memoryLeakList.clear();
        System.gc(); 
    }
}