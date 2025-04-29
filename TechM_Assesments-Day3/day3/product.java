package day2;

public class product {
	private String name;
    private double price;
    public product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; 
        product prod = (product) obj;
        return Double.compare(prod.price, this.price) == 0 && this.name.equals(prod.name);
    }
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
    public static void main(String[] args) {
        product p1 = new product("Laptop", 50000);
        product p2 = new product("Laptop", 50000);
        product p3 = new product("Smartphone", 30000);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }
}
