package array;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicateCharacter {


	 String remDupCharWithDS(String string) {
		 char[] ch=string.toLowerCase().toCharArray();
		LinkedHashSet<Character> listOfChar = new LinkedHashSet<>();
		for(Character c:ch) {
			listOfChar.add(c);
		}
		String s="";
	Iterator<Character> it=listOfChar.iterator();
	while(it.hasNext()) {
		s+=it.next();
	}
		 
		 return s;
	}
	 
	 String remDupChar(String s) {
		String result = "";
		
		char[] ch=s.toLowerCase().toCharArray();
		 for(int i=0;i<s.length();i++) {
			 int j=0;
			 for(j=0;j<i;j++) {
				if(ch[i]==ch[j]) {
					break;
				}
			 }
			 if(j==i) {
				 result+=ch[i];
			 }
			 }
		 return result;
			 }
			
	// Function to make the string unique 
	    public static String unique(String s) 
	    { 
	        String str = new String(); 
	        int len = s.length(); 
	          
	        // loop to traverse the string and 
	        // check for repeating chars using 
	        // IndexOf() method in Java 
	        for (int i = 0; i < len; i++)  
	        { 
	            // character at i'th index of s 
	            char c = s.charAt(i); 
	              
	            // if c is present in str, it returns 
	            // the index of c, else it returns -1 
	            if (str.indexOf(c) < 0) 
	            { 
	                // adding c to str if -1 is returned 
	                str += c; 
	            } 
	        } 
	          
	        return str; 
	    }
	public static void main(String[] args) {
		RemoveDuplicateCharacter rdc = new RemoveDuplicateCharacter();
		String s =rdc.remDupCharWithDS("Geekforgeeks");
		
		System.out.println(s);
		
	String s2 =rdc.remDupChar("Geekforgeeks");
		
		System.out.println(s2);
	}

}
