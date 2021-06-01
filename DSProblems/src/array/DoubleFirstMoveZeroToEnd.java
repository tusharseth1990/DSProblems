package array;
//arr[] = {2, 2, 0, 4, 0, 8}
public class DoubleFirstMoveZeroToEnd {

	
	void rearrange(int[] arr) {
		//doubling first & second to zero if same
		if(arr.length==1)
			return;
		for(int i=0;i<arr.length-2;i++) {
			if(arr[i]!=0 && arr[i]==arr[i+1]) {
				arr[i]=2*arr[i];
				arr[i+1]=0;
				i++;
			}
		}
	//shifting all zeroes to the end	
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)
			{
				arr[count++]=arr[i];
			}
		}
		while(count<arr.length) {
			arr[count++]=0;
		}
			
	}
	
	void print(int[] arr) {
		for(int x: arr) {
			System.out.println(x);
		}
		
	}
	
	public static void main(String[] args) {
		DoubleFirstMoveZeroToEnd d = new DoubleFirstMoveZeroToEnd();
		int arr[] = {2, 2, 0, 4, 0, 8};
		d.rearrange(arr);
		d.print(arr);
	}


	 

	 

}
