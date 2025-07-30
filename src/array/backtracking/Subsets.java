package array.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
//time  o(n * 2^n)
    //space o(n), 2^n output list
    // do this sol
    public List<List<Integer>> subsetsSol(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {

        //once it is equal to length means all calc done return all subsets
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        //decision to include num[i]
        dfs(nums, i + 1, subset, res);
        //decision to not include num[i] i.e =. []
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }

//Cascading
public List<List<Integer>> subsetsSol2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());

    for (int num : nums) {
        int size = res.size();
        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>(res.get(i));
            subset.add(num);
            res.add(subset);
        }
    }

    return res;
}

}
