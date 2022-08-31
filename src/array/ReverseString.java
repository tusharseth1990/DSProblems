package array;

public class ReverseString {

    String reverseString(String s)
    {
        String str="";
        //use String Builder
        if(s==null || s.isBlank())
        {
            System.out.println("Empty String");
            return "";
        }
        else {
            char ch[] = s.toCharArray();
            for(int i=ch.length-1;i>=0;i--)
            {
                str = str + ch[i];
            }
        }
        return str;
    }

    String reverseString1(String s)
    {
        String str="";
        if(s.isBlank() || s == "")
        {
            return "";
        }
        else{
            char ch[]=s.toCharArray();
            int left=0, right =ch.length-1;
            for(left=0;left<right;left++,right--)
            {
                char temp=ch[left];
                ch[left]=ch[right];
                ch[right]=temp;
            }
            return String.valueOf(ch);
            //new String(ch)
        }
    }

    void reverseStringUsingRecursion(String s)
    {
       if(s.length()==1 || s.isEmpty())
       {
           System.out.println(s);
       }
       else{
           System.out.println(s.charAt(s.length()-1));
           reverseStringUsingRecursion(s.substring(0,s.length()-1));
       }
    }

    String reverseStringUsingRecursion2(String s)
    {
        if(s.length()==1|| s.isEmpty())
        {
            return s;
        }
        else{
            return s.charAt(s.length()-1) + reverseStringUsingRecursion2(s.substring(0,s.length()-1));
        }
    }

    public static void main(String[] args) {
        ReverseString reverse = new ReverseString();
        System.out.println("The reverse of a string is ");
        System.out.println(reverse.reverseString("Reverse The String"));
        System.out.println("The reverse of a string is ");
        System.out.println(reverse.reverseString1("Reverse The String"));
        System.out.println("The reverse of a string is ");
        reverse.reverseStringUsingRecursion("Reverse The String");
        System.out.println("The reverse of a string is ");
        System.out.println(reverse.reverseStringUsingRecursion2("Reverse The String"));
    }
    }
