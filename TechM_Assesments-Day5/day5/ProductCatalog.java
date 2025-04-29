package day5;
import java.util.*;

// Product Class
class Product {
    int id;
    String name;
    double price;
    HashSet<String> categories; // Stores product categories

    // Constructor
    public Product(int id, String name, double price, HashSet<String> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    // Display Product Information
    @Override
    public String toString() {
        return "Product ID: " + id + " | Name: " + name + " | Price: $" + price + " | Categories: " + categories;
    }
}

// Comparator for Sorting by Price (Ascending)
class PriceAscendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.price, p2.price);
    }
}

// Comparator for Sorting by Price (Descending)
class PriceDescendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p2.price, p1.price);
    }
}

// Main Class
public class ProductCatalog {
    public static void main(String[] args) {
        // TreeMap to store products sorted by Product ID
        TreeMap<Integer, Product> productCatalog = new TreeMap<>();

        // Adding Products
        productCatalog.put(101, new Product(101, "Laptop", 1200.50, new HashSet<>(Arrays.asList("Electronics", "Computers"))));
        productCatalog.put(102, new Product(102, "Smartphone", 799.99, new HashSet<>(Arrays.asList("Electronics", "Mobile"))));
        productCatalog.put(103, new Product(103, "Headphones", 199.99, new HashSet<>(Arrays.asList("Electronics", "Audio"))));
        productCatalog.put(104, new Product(104, "Shoes", 89.99, new HashSet<>(Arrays.asList("Fashion", "Footwear"))));
        productCatalog.put(105, new Product(105, "Watch", 250.75, new HashSet<>(Arrays.asList("Fashion", "Accessories"))));

        // Display All Products (Sorted by Product ID)
        System.out.println("All Products (Sorted by Product ID):");
        for (Product product : productCatalog.values()) {
            System.out.println(product);
        }

        // Searching for Products in a Price Range
        double minPrice = 100;
        double maxPrice = 800;
        System.out.println("\nProducts in Price Range $" + minPrice + " - $" + maxPrice + ":");
        for (Product product : productCatalog.values()) {
            if (product.price >= minPrice && product.price <= maxPrice) {
                System.out.println(product);
            }
        }

        // Sorting Products by Price (Ascending Order)
        List<Product> productList = new ArrayList<>(productCatalog.values());
        productList.sort(new PriceAscendingComparator());
        System.out.println("\nProducts Sorted by Price (Ascending):");
        for (Product product : productList) {
            System.out.println(product);
        }

        // Sorting Products by Price (Descending Order)
        productList.sort(new PriceDescendingComparator());
        System.out.println("\nProducts Sorted by Price (Descending):");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
