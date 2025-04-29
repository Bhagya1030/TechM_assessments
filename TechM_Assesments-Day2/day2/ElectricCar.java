package day2;

public class ElectricCar extends Car{
	 private int batteryCapacity;

	    // Constructor
	    public ElectricCar(int speed, String fuelType, int numDoors, int batteryCapacity) {
	        super(speed, fuelType, numDoors);
	        this.batteryCapacity = batteryCapacity;
	    }
	    @Override
	    public void displayDetails() {
	        super.displayDetails();
	        System.out.println("Battery: " + batteryCapacity + " kWh");
	    }
	    public static void main(String[] args) {
	        // Create an ElectricCar object
	        ElectricCar tesla = new ElectricCar(120, "Electric", 4, 80);
	        tesla.displayDetails();
	    }
}
