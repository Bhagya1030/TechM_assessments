package day6;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Stock {
    private String symbol;
    private double price;
    private int volume;
    private LocalDateTime lastTradeTime;

    // Constructor
    public Stock(String symbol, double price, int volume, LocalDateTime lastTradeTime) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.lastTradeTime = lastTradeTime;
    }

    // Getters
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public int getVolume() { return volume; }
    public LocalDateTime getLastTradeTime() { return lastTradeTime; }

    // Display stock details
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Stock: " + symbol + " | Price: $" + price + " | Volume: " + volume +
               " | Last Trade: " + lastTradeTime.format(formatter);
    }
}

class StockMarketAnalyzer {
    private List<Stock> stocks;

    public StockMarketAnalyzer(List<Stock> stocks) {
        this.stocks = stocks;
    }

    // Find the highest-priced stock
    public Optional<Stock> getHighestPricedStock() {
        return stocks.stream()
                .max(Comparator.comparingDouble(Stock::getPrice));
    }

    // Calculate the average stock price
    public double getAverageStockPrice() {
        return stocks.stream()
                .mapToDouble(Stock::getPrice)
                .average()
                .orElse(0.0);  // Default to 0.0 if no stocks are present
    }

    // Get stocks traded in the last 24 hours
    public List<Stock> getRecentTrades() {
        LocalDateTime now = LocalDateTime.now();
        return stocks.stream()
                .filter(stock -> stock.getLastTradeTime().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
    }
}

// Main Class
public class StockMarApp {
    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(
            new Stock("AAPL", 175.25, 100000, LocalDateTime.now().minusHours(5)),
            new Stock("GOOGL", 2820.50, 150000, LocalDateTime.now().minusDays(2)), // Older than 24h
            new Stock("AMZN", 3435.75, 90000, LocalDateTime.now().minusHours(12)),
            new Stock("TSLA", 1080.45, 200000, LocalDateTime.now().minusHours(1)),
            new Stock("MSFT", 299.99, 120000, LocalDateTime.now().minusMinutes(30))
        );

        StockMarketAnalyzer analyzer = new StockMarketAnalyzer(stocks);

        // Find the highest-priced stock
        Optional<Stock> highestStock = analyzer.getHighestPricedStock();
        System.out.println("\n📈 Highest-Priced Stock:");
        System.out.println(highestStock.map(Stock::toString).orElse("No stocks available!"));

        // Calculate average stock price
        System.out.println("\n📊 Average Stock Price: $" + analyzer.getAverageStockPrice());

        // List stocks traded in the last 24 hours
        System.out.println("\n🔄 Stocks Traded in Last 24 Hours:");
        List<Stock> recentTrades = analyzer.getRecentTrades();
        if (recentTrades.isEmpty()) {
            System.out.println("No stocks traded in the last 24 hours.");
        } else {
            recentTrades.forEach(System.out::println);
        }
    }
}
