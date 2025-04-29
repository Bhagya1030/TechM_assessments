import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private final String accountNumber;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean transfer(BankAccount target, double amount) {
        BankAccount first = this.accountNumber.compareTo(target.accountNumber) < 0 ? this : target;
        BankAccount second = this == first ? target : this;

        first.lock.lock();
        try {
            second.lock.lock();
            try {
                if (this.balance >= amount) {
                    this.balance -= amount;
                    target.balance += amount;
                    System.out.println(Thread.currentThread().getName() + " transferred $" + amount + " from " + this.accountNumber + " to " + target.accountNumber);
                    return true;
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to transfer $" + amount + " due to insufficient balance.");
                    return false;
                }
            } finally {
                second.lock.unlock();
            }
        } finally {
            first.lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        ConcurrentHashMap<String, BankAccount> accounts = new ConcurrentHashMap<>();
        accounts.put("A1", new BankAccount("A1", 1000));
        accounts.put("A2", new BankAccount("A2", 1500));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable transferTask1 = () -> accounts.get("A1").transfer(accounts.get("A2"), 200);
        Runnable transferTask2 = () -> accounts.get("A2").transfer(accounts.get("A1"), 300);
        Runnable transferTask3 = () -> accounts.get("A1").transfer(accounts.get("A2"), 500);

        executor.execute(transferTask1);
        executor.execute(transferTask2);
        executor.execute(transferTask3);

        executor.shutdown();
    }
}