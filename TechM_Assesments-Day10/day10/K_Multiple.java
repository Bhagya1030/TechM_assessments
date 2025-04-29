package Tech_21;

public class K_Multiple {
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12};
		int n=arr.length;
		int k=10;
		int l;
		int r;
		for(int i=0;i<n;i=i+k)
		{
			 l=i;
			 if (i+k-1<n-1)
				 r=i+k-1;
			 else
				 r=n-1;
			while(l<=r)
			{
				int temp=arr[l];
				arr[l]=arr[r];
				arr[r]=temp;
				l++;
				r--;
			}

		}
		
				for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		
		
	}

}
