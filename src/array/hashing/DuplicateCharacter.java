package array.hashing;

import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class DuplicateCharacter {

    void printDuplicateCharacter(String s)
    {
        char[] ch=s.toLowerCase().toCharArray();
        LinkedHashMap<Character,Integer> hm = new LinkedHashMap<>();
        for (char c : ch) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
        }
        for(Entry<Character,Integer> en:hm.entrySet())
            {
            if(en.getValue()>1)
            {
                System.out.println(en.getKey() + ":" + en.getValue());
            }

        }
       // hm.entrySet().stream().filter((entry)->(entry.getValue()>1)).forEach((entry)->System.out.println(entry.getKey() + ":" +entry.getValue()));
    }

    void printDuplicatesByHashing(String s)
    {
       int count[]= new int[255];
       for(int i=0;i<s.length();i++)
       {
           count[s.charAt(i)]++;
       }
       for(int i=0;i<255;i++)
       {
           if(count[i]>1)
           {
               System.out.printf("%c  :",i);
               System.out.printf("%d",count[i]);
               System.out.println();
           }
       }
    }

    public static void main(String[] args) {
        DuplicateCharacter dc = new DuplicateCharacter();
        dc.printDuplicateCharacter("GeekforGeeks");
        dc.printDuplicatesByHashing("GeekforGeeks");
    }
}
