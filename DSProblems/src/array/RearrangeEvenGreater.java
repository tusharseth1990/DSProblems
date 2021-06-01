package arrays.rearrange;

import java.util.Arrays;

//Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
//Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
//Output : 4 5 3 6 2 7 1
//
//Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8} 
//1,1,2,4,5,6,8,8
//1,1,2,4    5,6,8,8
//Output : 4 5 2 6 1 8 1 8
public class RearrangeEvenGreater {

	
	void rearrangeArray(int[] arr,int n) {
int[] temp =new int[n];
for(int i=0;i<n;i++) {
	temp[i]=arr[i];
}
		Arrays.sort(temp);
int evenpos= n/2;     
int oddpos = n-evenpos;
int j=oddpos -1;
for(int i=0;i<n;i+=2)
{
	arr[i]=temp[j];
	j--;
}

j=oddpos;
for(int i=1;i<n;i+=2)
{
	arr[i]=temp[j];
	j++;
}
	}
	
	
//int j=n-1;
////odd pos 7,5,3,1
//	for(int i=n-1;i>=1;i-=2) {
//	arr[i]=temp[j--];
//	}
//
//	for(int i=n-2;i>0;i-=2) {
//		arr[i]=temp[j--];
//		}
//	}
	
	void printArray(int[] arr) {
		for(int x: arr) {
			System.out.println(x);
		}
		
	}
	public static void main(String[] args) {
		RearrangeEvenGreater reg=new RearrangeEvenGreater();
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int size=7;
		reg.rearrangeArray(arr,size);
		reg.printArray(arr);
	}

	 

	 

}
