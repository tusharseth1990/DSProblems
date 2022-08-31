package array.slidingwindow;

import java.util.HashMap;

public class LengthOfLongestSubString {

    int LongestSubstringLength(String s)
    {
        int n=s.length();
        int ans =0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0,j=0;j<n;j++)
        {
            if(hm.containsKey(s.charAt(j)))
            {
                i=Math.max(hm.get(s.charAt(j)),i);
            }
            ans=Math.max(ans,j-i+1);
            hm.put(s.charAt(j),j+1);
        }
        return ans;
    }

    int LongestUniqueSubstring(String s)
    {
        HashMap<Character,Integer> visited=new HashMap<>();
        int max_len=0;
        int start=0;
        for(int end=0;end<s.length();end++)
        {
            if(visited.containsKey(s.charAt(end)))
            {
                start= Math.max(start,visited.get(s.charAt(end))+1);
            }
            visited.put(s.charAt(end),end);
            max_len=Math.max(max_len,end-start+1);
        }
        return max_len;
    } //O(n+d)  where n is string length & d is the total no of english characters i.e.26 in worst case



    String LongestSubString(String s)
    {
        int n=s.length();
        String out="";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0,j=0;j<n;j++)
        {
            char curr= s.charAt(j);
            if(hm.containsKey(s.charAt(j)))
            {
                i=Math.max(hm.get(s.charAt(j)),i);
            }
            if(out.length()<j-i+1)
            {
                out=s.substring(i,j+1);
            }
            hm.put(s.charAt(j),j+1);
        }
        return out;
    }

    public static void main(String[] args) {
        String s="abcabcbdea";
        LengthOfLongestSubString longestSubStringlength = new LengthOfLongestSubString();
        System.out.println(longestSubStringlength.LongestSubstringLength(s));
        System.out.println(longestSubStringlength.LongestSubString(s));
        System.out.println(longestSubStringlength.LongestUniqueSubstring(s));
    }
}
