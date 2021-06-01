package array;

public class NthNoRemovingNoContainingDigitN {

	 // Function to find Nth number in base 9
	  static long findNthNumber(long N)
	  {
	 
	    // Stores the Nth number
	    long result = 0;
	 
	    long p = 1;
	 
	    // Iterate while N is
	    // greater than 0
	    while (N > 0) {
	 
	      // Update result
	      result += (p * (N % 9));
	 
	      // Divide N by 9
	      N = N / 9;
	 
	      // Multiply p by 10
	      p = p * 10;
	    }
	 
	    // Return result
	    return result;
	  }
	 
	  // Driver Code
	  public static void main(String[] args)
	  {
	    int N = 9;
	    System.out.print(findNthNumber(N));
	  }
	}

