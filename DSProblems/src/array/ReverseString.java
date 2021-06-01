package array;

public class ReverseString {
//tushar -- rahsut
	String reverseString(String s) {
		char[] c1=s.toCharArray();
		String newStr = "";
	
		for(int i=s.length()-1;i>=0;i--) {
		newStr=newStr+c1[i];
		}
	
		return newStr;
	}
	String reverseStringM2(String s) {
		char[] temp=s.toCharArray();
		int left=0; 
		int right=temp.length-1;
		for(left =0;left<right;left++ , right--) {
			char t=temp[left];
			temp[left] = temp [right];
			temp[right]=t;
		}
		return new String(temp);
	}
	
	String reverseStringByRecursion(String s) {
		if(s.length() <= 1 ) {
			return s;
			
		}else {
			return s.charAt(s.length()) + reverseStringByRecursion(s.substring(s.length()-1));
		}
	}
	public static void main(String[] args) {
		ReverseString rs=new ReverseString();
		String reversed= rs.reverseString("tushar");
System.out.println(reversed);
String reversed2= rs.reverseStringM2("tushar");
System.out.println(reversed);
String reverseStringByRecursion= rs.reverseStringM2("tushar");
System.out.println(reversed);
	}

}
