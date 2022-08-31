package array;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class GroupAnagramsTogether {

    List<List<String>> groupAnagrams(String[] strs)
    {
        if(strs.length==0)
        {
            return new ArrayList<>();
        }
        Map<String,List> hm=new HashMap<>();
        for(String s:strs) //n
        {
            char[] ch=s.toCharArray();
            Arrays.sort(ch);//nlogn
            String key=String.valueOf(ch);
            if(!hm.containsKey(key))
            {
                hm.put(key,new ArrayList());
            }
            hm.get(key).add(s);
        }
        return new ArrayList(hm.values());
    }

   List<List<String>> groupAnagram(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray())
                count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        GroupAnagramsTogether gp= new GroupAnagramsTogether();
        String[] str={"eat","tea","tan","ate","nat","bat"};
        System.out.println(gp.groupAnagrams(str));
    }
}
