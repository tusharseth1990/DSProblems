package array.tricky;

public class CountVowels {

    void countVowels(String str)
    {
        int vowels = 0;
        int consonants =0;
        for(char c:str.toCharArray())
        {
           if(c=='a'|| c=='e'|| c=='i' || c=='o'|| c=='u')
           {
               vowels++;
           }
           else if(c >='a' && c<='z') {
               consonants++;
            }
        }
        System.out.println("count of vowels : "+vowels);
        System.out.println("count of consonants : "+ consonants);
    }

    public static void main(String[] args) {
        String test ="Count the Vowels";
        CountVowels cv = new CountVowels();
        cv.countVowels(test.toLowerCase());
    }
}
