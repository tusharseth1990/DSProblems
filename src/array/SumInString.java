package array;

public class SumInString {

    static int findSum(String s)
    {
        String temp="0";
        int sum=0;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                temp=temp+ch;
            }
            else{
                sum=sum + Integer.parseInt(temp);
                temp="0";
            }
        }
        return sum + Integer.parseInt(temp);
    }

    public static void main(String[] args) {
        String str = "12abc20yz68";
        System.out.println(findSum(str));

    }
}
