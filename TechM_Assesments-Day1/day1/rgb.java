package day1;
public class rgb {
	public static int toGrayscale(int red, int green, int blue) {
        return ( (red * 77) + (green * 151) + (blue * 28) ) >> 8;
    }
    public static void main(String[] args) {
        int red = 120, green = 200, blue = 150;
        int grayscale = toGrayscale(red, green, blue);
        System.out.println("Grayscale value: " + grayscale);
    }
}