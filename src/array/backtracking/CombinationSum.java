package array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res;
    // time : o(2^t/m), space : o(t/m)

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList();
        backtrack(nums, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        // it can become -ve when target - number
        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }
// time : o(2^t/m), space : o(t/m)
    //t is given target and m is minimum value in nums
    public List<List<Integer>> combinationSumSol2(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            cur.add(nums[j]);
            dfs(j, cur, total + nums[j], nums, target);
            cur.remove(cur.size() - 1);
        }
    }

}
