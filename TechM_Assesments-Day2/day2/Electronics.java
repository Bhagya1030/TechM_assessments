package day2;

public class Electronics extends Prod {
	public Electronics(double price) {
        super(price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount for electronics
    }
}
