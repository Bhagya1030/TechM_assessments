package day2;

public class Clothing extends Prod{
	public Clothing(double price) {
        super(price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount for clothing
    }
}