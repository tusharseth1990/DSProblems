package array.hashing;

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

    static int getPairsCount(int[] arr, int sum) {
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(sum - arr[i])) {
                count += hm.get(sum - arr[i]);
               // count = count + hm.get(sum - arr[i]);
            }
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }
//        hm.forEach((key, value) -> System.out.println(key + ":" + value));
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5,3,3,5,4};
        //{1,5} {1,5} {1,5} {7,-1} {3,3}
        int n = arr.length;
        int sum = 6;
        System.out.print("Count of pairs is "
                + getPairsCount(arr, sum));
    }
}
