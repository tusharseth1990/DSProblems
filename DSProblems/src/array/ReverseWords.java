package array;

public class ReverseWords {
	 String reverseSentence(String s) {
		 String[] words=s.split(" ");
		 String ReverseSentence="";
		 for(int i=words.length-1;i>=0 ;i--) {
			 ReverseSentence+=" "+words[i];
		 }
		 
		 
		return ReverseSentence;		
	}
	
	public static void main(String[] args) {
		ReverseWords rw= new ReverseWords();
		String reverseSentence = rw.reverseSentence("I AM A GEEK");
		System.out.println(reverseSentence);
	}

	

}
