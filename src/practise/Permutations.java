package practise;

public class Permutations {

    static void permutations(String perm,String word)
    {
        if(word.isEmpty()){
            System.out.println(perm+word);
        }else{
            for(int i=0;i<word.length();i++)
            {
                permutations(perm + word.charAt(i),word.substring(0,i)+word.substring(i+1,word.length()));
            }
        }
    }

    public static void main(String[] args) {
        permutations("","1234");
    }
}
