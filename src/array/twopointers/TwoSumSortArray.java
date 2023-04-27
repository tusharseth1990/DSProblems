package array.twopointers;

import java.util.Arrays;
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//        Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//        The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//        Your solution must use only constant extra space.

//        Example 1:
//
//        Input: numbers = [2,7,11,15], target = 9
//        Output: [1,2]
//        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
public class TwoSumSortArray {

     int[] twoSum(int[] a, int target){
         int l = 0;
         int r = a.length-1;
         int currSum = 0;
         while(l < r){
             currSum = a[l] + a[r];
             if(currSum > target){
                 r = r -1;
             }
             else if(currSum < target){
                 l = l +1;
             }
             else {
                 return new int[] {l,r};
             }

         }
         return new int[]{};
     }
 // better efficient sol.
    public int[] twoSumSol(int[] numbers, int target) {
        int ans[]=new int[2];
        int i=0;
        int j=numbers.length-1;

        while(i<j){
            if(numbers[i]+numbers[j]==target){
                ans[0]=i+1;
                ans[1]=j+1;
                break;
            }
            else if(numbers[i]+numbers[j]>target)
                j--;
            else if(numbers[i]+numbers[j]<target)
                i++;
        }
        return ans;
    }

    public static void main(String[] args) {
         int[] a = {1,3,4,5,7,10,11};
        TwoSumSortArray twoSumSortArray = new TwoSumSortArray();
        int[] result =twoSumSortArray.twoSum(a,9);
        Arrays.stream(result).forEach(value -> System.out.println(value));
    }
}
