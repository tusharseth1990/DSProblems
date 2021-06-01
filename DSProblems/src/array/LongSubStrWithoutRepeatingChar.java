package array;
//  Longest Substring Without Repeating Characters
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashMap;
import java.util.Map;

public class LongSubStrWithoutRepeatingChar {
//Approach 1
    //pwwkew
	//i=0, j=0 

	public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
	
	
    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }
	
    //Approach 2
    public int lengthOfLongestSubstringSlidingWindow(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }
    
    //pwwkew
public int lengthOfLongestSubstringNew(String s) {
        
        Map<Character, Integer> map= new HashMap<>();
        int start=0, len=0;
        
        // abba
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start) 
                    start = map.get(c) + 1;
            }
            len = Math.max(len, i-start+1);
            map.put(c, i);
        }
        return len;
}
    public int lengthOfLongestSubstringSlidingWindowHashMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    
	public static void main(String[] args) {
		LongSubStrWithoutRepeatingChar l = new LongSubStrWithoutRepeatingChar();
		int length = l.lengthOfLongestSubstringSlidingWindow("pwwkew");
		System.out.println(length);
	}

}
