package array.twopointers;

import java.util.HashMap;
import java.util.Map;
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.
//        Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

public class TwoSum {
     int[] twoSum(int[] num, int target) {

         Map<Integer,Integer> hm = new HashMap<>();
         for (int i = 0; i < num.length; i++) {
             int compliment = target - num[i];
             if(hm.containsKey(compliment)){
                 return new int[] { hm.get(compliment),i };
             }
             hm.put(num[i],i);
         }
         return null;
    }
    public static void main(String[] args) {
        int[] arr = {4,-2,5,0,6,3,2,7};
         TwoSum twoSum = new TwoSum();
        twoSum.twoSum(arr,1);
    }
}
