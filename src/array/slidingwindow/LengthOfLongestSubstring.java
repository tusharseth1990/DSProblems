package array.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//sliding window
public class LengthOfLongestSubstring {

    private static int findLengthOfLongSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            while (hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left = left + 1;
            }
            hs.add(s.charAt(right));
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }


    //another sol.

    public int lengthOfLongestSubstring(String s) {
        List<Character> substringL = new ArrayList<>();
        int largestlength = 0;
        for(int right = 0; right < s.length(); right++) {
            if(substringL.contains(s.charAt(right))) {
                // get the index of the char
                int index = substringL.indexOf(s.charAt(right));
                substringL.remove(index);
                if(index > 0)
                    substringL.subList(0, index).clear();
            }
            substringL.add(s.charAt(right));
            largestlength = Math.max(largestlength, substringL.size());
        }
        return largestlength;
    }
    public static void main(String[] args) {
        int length = findLengthOfLongSubstring("abcabcba");
        System.out.println(length);
    }


}
