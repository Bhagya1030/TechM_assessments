package Tech_21;
import java.util.ArrayList;
import java.util.HashSet;

public class Pair_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]= {1,4,9,8,25,5,12};
int n=13;
ArrayList<Integer> l=new ArrayList<Integer>();
for(int i=0;i<arr.length;i++)
{
	int target=n-arr[i];
	if(l.contains(target))
	{
		System.out.println(arr[i]+ " "+target);
	}
	l.add(arr[i]);
}

	}
}
