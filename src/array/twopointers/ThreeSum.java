package array.twopointers;

import java.util.*;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//        Notice that the solution set must not contain duplicate triplets.
//n logn + n2 = n2
public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //if there are no negative no & 0 is there the res not possible

            if (nums[i] > 0) break;
            //skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else { // sum == 0
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    //skip duplicates
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSumII(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }

    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
       List<List<Integer>> list = threeSum.threeSum(num);
       list.stream().forEach(integers -> System.out.println(integers));
    }
}
