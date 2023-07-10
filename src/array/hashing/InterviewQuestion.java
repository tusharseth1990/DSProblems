package array.hashing;

import java.util.*;

public class InterviewQuestion {
//
    void secondLargestUniqueElement(int[] arr, int k)
    {
        SortedMap<Integer,Integer> sm= new TreeMap<>();
        for(int i:arr)
        {
            sm.put(i,sm.getOrDefault(i,0)+1);
        }
        List<Integer> ls= new ArrayList<>();
        for(Map.Entry<Integer,Integer> e: sm.entrySet())
        {
            if(e.getValue()==1)
            {
                ls.add(e.getKey());
            }
        }
        System.out.println(ls.get(ls.size()-k));
    }

    public static void main(String[] args) {
        int[] a = {5,6,14,24,14,24,2,3,45};
        {}
        InterviewQuestion t = new InterviewQuestion();

        t.secondLargestUniqueElement(a,2);
    }
}
