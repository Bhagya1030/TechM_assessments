package day1;

public class reversebits {

	public static void main(String[] args) {
		int num = 5;
        int reversednum = 0;
        for(int i=0;i<8;i++){
            reversednum = (reversednum << 1) | (num & 1);
            num >>= 1;
        }
        System.out.println("Reversed Binary :" + Integer.toBinaryString(reversednum));
        System.out.println(+reversednum);

	}
}