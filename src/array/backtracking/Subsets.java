package array.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    public static void main(String[] args) {
    int[] nums = {1,2,3};
        Subsets s = new Subsets();
    List<List<Integer>> answer = s.subsets(nums);
    answer.stream().forEach(integers -> System.out.println(integers.toString()));
    }
//Cascading
    public List<List<Integer>> subsetsSol1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int n: nums){
            int size = list.size();
            for(int i=0;i<size;i++){
                List<Integer> subset = new ArrayList<>(list.get(i));
                subset.add(n);
                list.add(subset);
            }
        }
        return list;
    }


}
