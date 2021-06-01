package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

//f the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
public class FormBiggestNo {


	 // The main function that prints the  
    // arrangement with the largest value. 
    // The function accepts a vector of strings     
    static void printLargest(ArrayList<String> arr){ 
      
        Collections.sort(arr, new Comparator<String>(){ 
  
        // A comparison function which is used by  
        // sort() in printLargest() 
        @Override
        public int compare(String X, String Y) { 
          
        // first append Y at the end of X 
        String XY=X + Y; 
          
        // then append X at the end of Y 
        String YX=Y + X; 
          
        // Now see which of the two formed numbers  
        // is greater 
        return XY.compareTo(YX) > 0 ? -1:1; 
    } 
    }); 
          
    Iterator it = arr.iterator(); 
  
    while(it.hasNext()) 
        System.out.print(it.next()); 
      
    } 
      
    // driver program 
    public static void main (String[] args) { 
          
        ArrayList<String> arr; 
        arr = new ArrayList<>(); 
          
        //output should be 6054854654 
        arr.add("54"); 
        arr.add("546"); 
        arr.add("548"); 
        arr.add("60"); 
        printLargest(arr); 
    } 

}
