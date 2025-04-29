package day2;

abstract class Prod {
	protected double price;

    // Constructor
    public Prod(double price) {
        this.price = price;
    }
    // Abstract method to be implemented by subclasses
    public abstract double calculateDiscount();
}
