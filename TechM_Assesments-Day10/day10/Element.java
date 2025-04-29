/*
 *  Majority Element
Easy
Topics
Companies
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 */



package Tech_21;

public class Element {
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5,1,1,1,1,1};
		int n=arr.length;
		System.out.println(n);
		
		int result=findMajority(arr);
		if(result!=-1)
			System.out.println(result);
		else
			System.out.println("No majority element");
		
	}

	private static int findMajority(int[] arr) {
		// TODO Auto-generated method stub
		
		
		int candidate=findCandidate(arr);
		return isMajority(arr,candidate)?candidate:-1;
		
		
		}

	private static boolean isMajority(int[] arr, int candidate) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(candidate==arr[i])
				count++;
		}
		
		return (count>(arr.length/2));
	}

	private static int findCandidate(int[] arr) {
		// TODO Auto-generated method stub
		int count=0,candidate=0;
		for(int i=0;i<arr.length;i++)
		{
			if(count==0)
				candidate=arr[i];
			if(arr[i]==candidate)
				count++;
			else
				count--;
		}
		
		
		return candidate;
	}

}
