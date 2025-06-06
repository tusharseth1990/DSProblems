package array.slidingwindow;

//You are given a string s and an integer k. You can choose any character of the string and
// change it to any other uppercase English character. You can perform this operation at most k
// times.
//
//Return the length of the longest substring containing the same letter you can get after
// performing the above operations.

import java.util.HashMap;

//Input: s = "ABAB", k = 2
//        Output: 4
//        Explanation: Replace the two 'A's with two 'B's or vice versa.
public class LongestRepeatingCharacterReplacement {
 /*
 https://leetcode.com/problems/longest-repeating-character-replacement/
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
// O(n)
//logic: windowLength - maxFrequency <= k
     */

    public int characterReplacementHashMap(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;

        int l = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
 public int characterReplacement(String s, int k) {
     // Initialising an empty array to store the count of the
     // characters in the given string s
     int[] arr = new int[26];
     int res = 0;
     int max = 0;

     // The left pointer for the sliding window is l AND  r is the
     // right pointer
     int l = 0;
     for (int r = 0; r < s.length(); r++) {
         // Counting the number of each character in the string s
         arr[s.charAt(r) - 'A']++;

         // Checking the character with max number of occurrence
         max = Math.max(max, arr[s.charAt(r) - 'A']);

         // Now we check if our current window is valid or not
         if (r - l + 1 - max > k) {
             // this means the no. of replacements is more than
             // allowed (k)
             // Decrementing the count of the character which was
             // at l because it is no longer in the window
             arr[s.charAt(l) - 'A']--;
             l++;
         }

         // The max our window can be
         res = Math.max(res, r - l + 1);
     }

     return res;
 }
}
