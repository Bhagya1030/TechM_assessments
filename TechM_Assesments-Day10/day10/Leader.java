package Tech_21;
import java.util.Arrays;

public class Leader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {10,22,12,3,0,6};
		int n=arr.length;
		boolean leader=true;
		for(int i=0;i<n;i++)
		{
			leader=true;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]>arr[i])
				{
					leader=false;
					break;
				}
			}
			if(leader)
				System.out.println(arr[i]);
		}
		
		
		
		
	}

}

