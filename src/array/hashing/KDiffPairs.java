package array.hashing;

import java.util.*;

//“Given an integer array nums and an integer k, return the number of unique k-diff
// pairs in the array.”
//A k-diff pair is defined as:
//A pair of integers (a, b) where:
//
//|a - b| = k
//
//"Unique" means (a, b) and (b, a) count as the same pair.
public class KDiffPairs {
    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // absolute difference can't be negative

        //1 3 5
        Set<Integer> seen = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num - k))
                pairs.add(num - k);
            if (seen.contains(num + k))
                pairs.add(num);
            seen.add(num);
        }
        return pairs.size();

    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2)); // 2 -> (1,3), (3,5)
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1)); // 4 -> (1,2),(2,3),(3,4),(4,5)
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0)); // 1 -> only "1" appears twice
    }
}

