package day2;

public class Car extends Vehicle{
	protected int numDoors;
    public Car(int speed, String fuelType, int numDoors) {
        super(speed, fuelType);
        this.numDoors = numDoors;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Doors: " + numDoors);
    }
}