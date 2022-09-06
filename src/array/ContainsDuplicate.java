package array;

import java.util.HashSet;
import java.util.Set;

//Given an integer array nums, return true if any value appears at
// least twice in the array, and return false if every element is distinct.
//Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
public class ContainsDuplicate {

    private static boolean findDuplicates(int[] a) {
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < a.length-1; i++) {
            if(s1.contains(a[i])){
                return true;
            }
            s1.add(a[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] a = {1,1,1,3,3,4,3,2,4,2};
        boolean b = findDuplicates(a);
    }


}
