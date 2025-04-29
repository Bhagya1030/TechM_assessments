package Tech_21;
import java.util.Arrays;

public class Max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {10,22,12,3,0,6};
		int n=arr.length;
		int max=arr[n-1];
		System.out.println(max);
		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			System.out.println(arr[i]);
			}
		}
		
	}

}
