package day1;

public class integercomp {
	private static final int SECRET_KEY = 0x5A5A5A5A;
    public static int encode(int num) {
        return num ^ SECRET_KEY;
    }
    public static int decode(int encodedNum) {
        return encodedNum ^ SECRET_KEY;
    }
    public static void main(String[] args) {
        int original = 12345;
        int encoded = encode(original);
        int decoded = decode(encoded);
        System.out.println("Original: " + original);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
    }
}