package array.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAllAnagramsInAString {

    public static List<Integer> findAllAnagrams(String s1, String s2){
        List<Integer> result = new ArrayList<>();
        //corner case

        if(s2.length() > s1.length()){
            return result;
        }

        int[] pattern = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            pattern[s2.charAt(i) - 'a']++;
        }

        int[] window = new int[26];
        for (int i = 0; i < s2.length() - 1; i++) {
            window[s1.charAt(i) - 'a']++;
        }


        for (int i = s2.length()-1; i < s1.length(); i++) {

            window[s1.charAt(i) - 'a']++;
            if(Arrays.equals(pattern,window)){
                result.add(i-s2.length()+1);
            }
            window[s1.charAt(i-s2.length()+1) - 'a']--;


        }
        return result;
    }
    public static void main(String[] args) {
        //s = "cbaebabacd", p = "abc"
        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> output = findAllAnagrams(s1,s2);
        System.out.println(output);
    }
}
