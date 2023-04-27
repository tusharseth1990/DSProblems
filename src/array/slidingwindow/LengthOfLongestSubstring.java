package array.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//sliding window
public class LengthOfLongestSubstring {
//neet code solution
// sliding window
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


    public static void main(String[] args) {
        int length = findLengthOfLongSubstring("abcabcba");
        System.out.println(length);
    }


}
