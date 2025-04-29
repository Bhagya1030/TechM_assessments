package day1;

public class discal {
	public static double calculateFinalPrice(double cartValue) {
        double discount = 0;
        if (cartValue > 500) {
            discount = 0.20;
        } else if (cartValue >= 100 && cartValue <= 500) {
            discount = 0.10; 
        }
        double finalPrice = cartValue - (cartValue * discount);
        return finalPrice;
    }
    public static void main(String[] args) {
        System.out.println("Final Price: $" + calculateFinalPrice(600));
        System.out.println("Final Price: $" + calculateFinalPrice(300));
        System.out.println("Final Price: $" + calculateFinalPrice(50));
    }
}