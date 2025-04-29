package Tech_21;
public class Reverse_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,3,4,5,6};
		int n=arr.length;
		int l=0;
		int r=n-1;
		while(l<=r)
		{
			int temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			l++;
			r--;
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(arRr[i]+" ");
		}
		
		
		
	}

}
