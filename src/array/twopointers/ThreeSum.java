package array.twopointers;

import java.util.*;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//        Notice that the solution set must not contain duplicate triplets.
public class ThreeSum {

    List<List<Integer>> threeSum(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> response = new ArrayList<>();
        for (int i = 0; i < arr.length && arr[i] <= 0; i++) {
            if(i ==0 || arr[i-1] != arr[i]) {
                twoSumII(arr,i,response);
            }
        }
        return response;
    }

     void twoSumII(int[] arr, int i, List<List<Integer>> response) {
        int l = i+1;
        int r = arr.length-1;
        while (l<r){
            int sum = arr[i] + arr[l] + arr[r];
            if(sum < 0){
                ++l;
            }
            else if(sum > 0){
                --r;
            }else {
                response.add(Arrays.asList(arr[i],arr[l++],arr[r--]));
                while (l < r && arr[l] == arr[l-1]);
                ++l;
            }
        }
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
