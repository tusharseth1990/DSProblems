package array.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given an integer array nums, return true if any value appears at
// least twice in the array, and return false if every element is distinct.
//Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
public class ContainsDuplicate {
//Time Complexity = n
    //Space Complexity = n

    private static boolean findDuplicates(int[] a) {
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if(s1.contains(a[i])){
                return true;
            }
            s1.add(a[i]);
        }
        return false;
    }

    //time & space o(n)
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    //time nlogn
    //space o(1) or o(n) depending on sorting algo
    public boolean hasDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] a = {1,1,1,3,3,4,3,2,4,2};
        int[] a = {1,3,4,2,2};
        boolean b = findDuplicates(a);
        System.out.println(b);
    }


}
