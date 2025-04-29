package day1;

import java.util.Scanner;

public class poweroftwo {
	public static boolean ispotwo(int n) {
		return(n>0)&&((n&(n-1))==0);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(ispotwo(n)) {
			System.out.println("Yes,it is a power of two");
		}
		else
			System.out.println("No,it is not power of two");
	}
}