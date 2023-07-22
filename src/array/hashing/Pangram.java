package array.hashing;

import java.util.HashSet;
import java.util.Set;

public class Pangram {

	public boolean checkIfPangram(String sentence) {
		// Empty set 'seen'.
		Set<Character> seen = new HashSet<>();

		// Iterate over 'sentence' add every letter to 'seen'.
		for (char currChar : sentence.toCharArray())
			seen.add(currChar);

		// If the size of 'seen' is 26, then 'sentence' is a pangram.
		return seen.size() == 26;
	}

	public boolean checkIfPangramUsingHashing(String sentence)
	{
		boolean[] chars= new boolean[26];
		for(char ch:sentence.toCharArray())
		{
			chars[ch='a']=true;
		}

		for(boolean status:chars)
		{
			if(!status)
			{
				return false;
			}
		}
		return true;
	}

	 public static boolean checkPangram(String str) 
	    { 
	        // Create a hash table to mark the 
	        // characters present in the string 
	        // By default all the elements of 
	        // mark would be false. 
	        boolean[] mark = new boolean[26]; 
	  
	        // For indexing in mark[] 
	        int index = 0; 
	  
	        // Traverse all characters 
	        for (int i = 0; i < str.length(); i++) { 
	            // If uppercase character, subtract 'A' 
	            // to find index. 
	            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') 
	                index = str.charAt(i) - 'A'; 
	  
	            // If lowercase character, subtract 'a' 
	            // to find index. 
	            else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') 
	  
	                index = str.charAt(i) - 'a'; 
	  
	            // If this character is other than english 
	            // lowercase and uppercase characters. 
	            else
	                continue; 
	            mark[index] = true; 
	        } 
	  
	        // Return false if any character is unmarked 
	        for (int i = 0; i <= 25; i++) 
	            if (mark[i] == false) 
	                return (false); 
	  
	        // If all characters were present 
	        return (true); 
	    } 
	  
	 
	 
	public static void main(String[] args) {
		String str = "The quick ,brown fox jumps over the lazy dog.";
		  
        if (checkPangram(str) == true) 
            System.out.print(str + " is a pangram."); 
        else
            System.out.print(str + " is not a pangram.");
	}

}
