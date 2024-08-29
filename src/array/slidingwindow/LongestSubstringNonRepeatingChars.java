package array.slidingwindow;

import java.util.HashSet;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
/*
Given a string s, find the length of the longest
substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
sliding window
 */
// T & S= O(n)
public class LongestSubstringNonRepeatingChars {
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
