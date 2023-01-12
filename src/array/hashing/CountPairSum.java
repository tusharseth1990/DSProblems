package array.hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
Input  :  arr[] = {1, 5, 7, -1},
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)

Input  :  arr[] = {1, 5, 7, -1, 5},
          sum = 6
Output :  3
 */
public class CountPairSum {

    static int getPairsCount(int arr[],int n, int k)
    {
        LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<>();
        int count =0;
        for(int i=0;i<arr.length;i++)
        {
            if(hm.containsKey(k-arr[i])){
                count+= hm.get(k-arr[i]);
            }
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else{
              hm.put(arr[i],1);
            }
        }
        hm.entrySet().stream().forEach(entry-> System.out.println(entry.getKey() +":" +entry.getValue() ));
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 7, -1, 5};
        int n = arr.length;
        int sum = 6;
        System.out.print("Count of pairs is "
                + getPairsCount(arr, n, sum));
    }
}
