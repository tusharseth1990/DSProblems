package array;

import java.util.Arrays;
//Reorder an array according to given indexes
//Input:  arr[]   = [50, 40, 70, 60, 90]
//        index[] = [3,  0,  4,  1,  2]
//Output: arr[]   = [40, 60, 90, 50, 70]
//        index[] = [0,  1,  2,  3,   4] 
public class Reorder {

	
	    static int arr[] = new int[]{50, 40, 70, 60, 90}; 
	    static int index[] = new int[]{3,  0,  4,  1,  2}; 
	      
	    // Method to reorder elements of arr[] according 
	    // to index[] 
	    static void reorder() 
	    { 
	        int temp[] = new int[arr.length]; 
	       
	        // arr[i] should be present at index[i] index 
	        for (int i=0; i<arr.length; i++) 
	            temp[index[i]] = arr[i]; 
	       
	        // Copy temp[] to arr[] 
	        for (int i=0; i<arr.length; i++) 
	        {  
	           arr[i]   = temp[i]; 
	           index[i] = i; 
	        } 
	    } 
	      
	    // Driver method to test the above function 
	    public static void main(String[] args)  
	    { 
	          
	        reorder(); 
	          
	        System.out.println("Reordered array is: "); 
	        System.out.println(Arrays.toString(arr)); 
	        System.out.println("Modified Index array is:"); 
	        System.out.println(Arrays.toString(index)); 
	          
	    } 

}
