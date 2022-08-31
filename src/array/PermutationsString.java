package array;

public class PermutationsString {

    void permute(String s,String ans)
    {
        if(s.length()==0)
        {
            System.out.println(ans + " ");
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            String leftstr=s.substring(0,i);
            String rightstr=s.substring(i+1);
            String rest = leftstr+rightstr;
            permute(rest,ans+ch);
        }
    }

    public static void main(String[] args) {
        PermutationsString perm= new PermutationsString();
        String s="ABC";
        String ans="";
        perm.permute(s,ans);
    }
}
