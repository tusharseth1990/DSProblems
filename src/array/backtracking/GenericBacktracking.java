package array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericBacktracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


//    Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/

//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
//        list.add(new ArrayList<>(tempList));
//        for(int i = start; i < nums.length; i++){
//            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        GenericBacktracking s = new GenericBacktracking();
        List<List<Integer>> answer = s.subsets(nums);
        answer.stream().forEach(integers -> System.out.println(integers.toString()));
    }
}
