package array.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class GroupAnagramsTogether {

    //m.nlogn
    List<List<String>> groupAnagrams(String[] strs)
    {
        if(strs.length==0)
        {
            return new ArrayList<>();
        }
        Map<String,List<String>> hm=new HashMap<>();
        for(String s:strs) //n
        {
            char[] ch=s.toCharArray();
            Arrays.sort(ch);//nlogn
            String key=String.valueOf(ch);
            if(!hm.containsKey(key))
            {
                hm.put(key,new ArrayList<>());
            }
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
    //java 8 solution
    public List<List<String>> groupAnagramsUsingJava8(String[] strs) {
        Map<String, List<String>> d = new HashMap<>();
        for (String s : strs) {
            char[] t = s.toCharArray();
            Arrays.sort(t);
            String k = String.valueOf(t);
            d.computeIfAbsent(k, key -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(d.values());
    }



    //m.n.26
   List<List<String>> groupAnagram(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
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
            System.out.println(key);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        GroupAnagramsTogether gp= new GroupAnagramsTogether();
        String[] str={"eat","tea","tan","ate","nat","bat"};
        System.out.println(gp.groupAnagram(str));
    }
}
