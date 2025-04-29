package day2;
public class Vehicle {
	protected int speed;
	protected String fuelType;
	public Vehicle(int speed, String fuelType) {
		this.speed = speed;
		this.fuelType = fuelType;
	}
	public void displayDetails() {
		System.out.println("Speed: " + speed + " km/h, Fuel Type: " + fuelType);
	}
}