package string;


import java.util.HashMap;
import java.util.Map.Entry;

public class DuplicateCharacter {


	void printDuplicateChar(String s) {
		char[] ch= s.toLowerCase().toCharArray();
		HashMap<Character,Integer> hm =new HashMap<>();
		for(int i=0;i<ch.length;i++) {
			if(hm.containsKey(ch[i])) {
				hm.put(ch[i], hm.get(ch[i])+1);
			}else {
				hm.put(ch[i], 1);
			}
		}
		for(Entry<Character,Integer> en: hm.entrySet()) {
			if(en.getValue()>1) {
				System.out.println(en.getKey()+ " "+ en.getValue());
			}
		}
	}
	
	
	void printDuplicateCharByHashing(String s) {
		int count[] =new int[255];
		for(int i=0;i<s.length()-1;i++) {
			count[s.charAt(i)]++;
		}
		for(int j=0;j<count.length-1;j++) {
			if(count[j]>1) {
				//System.out.printf( "%c,count = %d ",j, count[j]);
				System.out.printf( "%c",j);
				System.out.printf( "=%d\n",count[j]);
			}
			
			
		
			
		}
	}

	public static void main(String[] args) {
		DuplicateCharacter dc = new DuplicateCharacter();
		
		//dc.printDuplicateChar("Geekforgeeks");
		dc.printDuplicateCharByHashing("Geekforgeeks");
		
	}


}
