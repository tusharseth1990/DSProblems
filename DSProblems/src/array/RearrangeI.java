package array;

import java.util.HashSet;
import java.util.Set;

//Rearrange an array such that arr[i] = i
//arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
public class RearrangeI {

	
	void rearrange(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=-1 && arr[i]!=i) {
				int x=arr[i];
				while(arr[x]!=-1 && arr[x]!=x) {
					int y = arr[x];
					arr[x]=x;
					x=y;
				}
				arr[x]=x;
				if(arr[i]!=i) {
					arr[i]=-1;
				}
			}
			
		}
		
	}
	
	public  void rearrangeWithDS(int[] A) 
    { 
        Set<Integer> s = new HashSet<Integer>(); 
  
        // Storing all the values in the HashSet 
        for(int i = 0; i < A.length; i++) 
        { 
           s.add(A[i]); 
        } 
  
        for(int i = 0; i < A.length; i++) 
        { 
           if(s.contains(i)) 
             A[i] = i; 
           else
             A[i] = -1; 
        } 
  
      
} 
	
	void printArray(int[] arr) {
		for(int x:arr) {
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		RearrangeI ri=new RearrangeI();
		
		int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		//ri.printArray(arr);
		ri.rearrange(arr);
		ri.printArray(arr);
//		ri.rearrangeWithDS(arr);
//		ri.printArray(arr);
	}

	 

}
