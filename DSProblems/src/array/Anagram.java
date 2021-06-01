package array;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

	
	public boolean isAnagram(String s1, String s2) {
		char[] c1= s1.toLowerCase().toCharArray();
		char[] c2= s2.toLowerCase().toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(s1.length()!=s2.length()) {
			return false;
		}
		else {
		for (int i=0;i<c1.length-1;i++) {
			if(c1[i]!=c2[i]) {
				return false;
			}
		}
		return true;
		}
		
	}

	public boolean isAnagramWithDS(String s1, String s2) {
		char[] c1= s1.toLowerCase().toCharArray();
		char[] c2= s2.toLowerCase().toCharArray();
		if(s1.length()!=s2.length()) {
			return false;
		}
		HashMap<Character,Integer> hm = new HashMap<>();
		for(Character ch:c1) {
			if(hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch)+1);
			}
			else {
				hm.put(ch, 1);

			}
			
		}
		
	for(Character ch:c2) {
		if(hm.get(ch)> 1) {
			hm.put(ch, hm.get(ch)-1);
		}
		else if(hm.get(ch)==1) {
			hm.remove(ch);
		}
		else{
			hm.put(ch,1);
		}
		
	}
	if(hm.isEmpty())
		return true;
	else
		return false;
	
	}
	public static void main(String[] args) {
Anagram ag=new Anagram();
boolean anagram=ag.isAnagramWithDS("peeseak","keaeesp");
System.out.println(anagram);
	}
	 
}
