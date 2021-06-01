package array;

import java.util.ArrayList;

public class AddNumberByOneArray {

	static void incrementVector(ArrayList<Integer> a) 
    { 
        int n = a.size(); 
      
        // Add 1 to last digit and find carry 
        a.set(n - 1, a.get(n - 1) + 1); 
        int carry = a.get(n - 1) / 10; 
        a.set(n - 1, a.get(n - 1) % 10); 
      
        // Traverse from second last digit 
        for (int i = n - 2; i >= 0; i--) 
        { 
            if (carry == 1) 
            { 
            a.set(i, a.get(i) + 1); 
            carry = a.get(i) / 10; 
            a.set(i, a.get(i) % 10); 
            } 
        } 
      
        // If carry is 1, we need to add 
        // a 1 at the beginning of vector 
        if (carry == 1) 
        a.add(0, 1); 
    } 
      
    // Driver code 
    public static void main (String[] args)  
    { 
    	ArrayList<Integer> vect=new ArrayList<Integer>(); 
        vect.add(1); 
        vect.add(7); 
        vect.add(8); 
        vect.add(9); 
          
        incrementVector(vect); 
      
        for (int i = 0; i < vect.size(); i++) 
        System.out.print(vect.get(i) + " "); 
        } 

}
