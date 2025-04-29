package Tech_21;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {0,1,1,1,0,1,0,2,1,2};
		int n=arr.length;
		System.out.println("Original array"+ Arrays.toString(arr));
		sortColors(arr);
		System.out.println("After sorted array"+ Arrays.toString(arr));
		
		
		
		
		
	}

	private static void sortColors(int[] arr) {
		// TODO Auto-generated method stub
		int n=arr.length;
		int low=0,mid=0,high=n-1;
		while(mid<=high)
		{
			switch(arr[mid])
			{
			case 0:swap(arr,mid,low);
					low++;
					mid++;
					break;
					
				
			case 1:mid++;
					break;
				
			case 2:swap(arr,mid,high);
					high--;
					break;
				
				
			}
		}

}
}