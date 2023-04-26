package array.hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstRepeatingInteger {

    static void firstRepeatingElement(int[] arr)
    {
        HashMap<Integer,Integer> hm=new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            else{
                hm.put(arr[i],1);
            }
        }
        for (int j : arr) {
            if (hm.get(j) > 1) {
                System.out.println(j);
                System.exit(1);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = { 10, 5, 3, 4, 3, 5, 6 };
        firstRepeatingElement(arr);
        //System.out.println(k);
    }
}
