package array.hashing;

import java.util.*;

public class Anagram {
     //convert both strings into character array
    //then sort it & compare each character by traversing

    //nlogn + nlogn + n
    // n logn
    boolean areAnagrams(String s1, String s2)
    {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        char ch1[]= s1.toLowerCase().toCharArray();
        char ch2[]= s2.toLowerCase().toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i< ch1.length;i++)
        {
            if(ch1[i]!=ch2[i])
            {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }



    //if length is unequal return false
    //convert strings to character array
    //take 2 hashmaps,
    // traverse 1st character array and put in hashmap i.e. char key , occurrence
    // traverse 2nd character array and put in hashmap i.e. char key , occurrence
    //And compare both hashmap are equals or not.

    //another solution traverse 1st character array & put in hashmap & traverse another
    //char array and keep deleting the existing char and in the end if it is empty then
    //it is anagram

    //n + n = n - time complexity
    //n - space complexity
    boolean areAnagramWithDS(String s1,String s2)  {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        HashMap<Character,Integer> hm1= new HashMap<>();
        HashMap<Character,Integer> hm2= new HashMap<>();
        char ch1[]=s1.toLowerCase().toCharArray();
        char ch2[]=s2.toLowerCase().toCharArray();
        for(int i=0;i<ch1.length;i++)
        {
            if(hm1.containsKey(ch1[i]))
            {
                hm1.put(ch1[i],hm1.get(ch1[i])+1);
            }
            else {
                hm1.put(ch1[i], 1);
            }

            if(hm2.containsKey(ch2[i]))
            {
                hm2.put(ch2[i],hm2.get(ch2[i])+1);
            }
            else{
                hm2.put(ch2[i],1);
            }

           // hm2.put(ch2[i],hm2.getOrDefault(ch2[i],0)+1);
        }
        if(hm1.equals(hm2))
        {
            return true;
        }
        else{
            return false;
        }
    }


    // n + 255(constant) = n
    static int CHARS = 255;
    boolean areAnagramByHashing(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        int[] count1 =new int[CHARS];
        int[] count2 =new int[CHARS];
        for(int i=0;i< s1.length();i++)
        {
            count1[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;
        }
        for(int i=0;i<CHARS;i++)
        {
            if(count1[i]!=count2[i])
            {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Anagram anagram = new Anagram();
       // LinkedList<Integer> n= new LinkedList<>();
        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                (n)->System.out.println(n)
        );
        if(anagram.areAnagramByHashing("peeseak","keaeesp"))
        {
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not an Anagram");
        }

        System.out.println("With DS");
        if(anagram.areAnagramWithDS("peeseak","keaeesp"))
        {
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not an Anagram");
        }
    }

}
