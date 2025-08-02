package array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input: An array nums and a target sum target.
//Goal: Find all unique combinations of numbers in nums that sum up to target. Each number can be used multiple times

//Initialization:
//res: A list to store all valid combinations.
//cur: A temporary list to store the current combination during recursion.
//Recursive Function (backtrack):
//Base Case 1: If target == 0, add the current combination (cur) to res.
//Base Case 2: If target < 0 or i >= nums.length, terminate the recursion.
//Recursive Steps:
//Include nums[i] in the combination and reduce target by nums[i].
//Exclude nums[i] and move to the next index.

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


    //Dry Run Example:
    //Input: nums = [2, 3], target = 5
    //Initial Call: backtrack(nums, 5, [], 0)
    //i = 0, cur = [].
    //Include nums[0] = 2:
    //cur = [2], target = 3.
    //Recursive call: backtrack(nums, 3, [2], 0).
    //Include nums[0] = 2 again:
    //cur = [2, 2], target = 1.
    //Recursive call: backtrack(nums, 1, [2, 2], 0).
    //Include nums[0] = 2 again:
    //cur = [2, 2, 2], target = -1.
    //Base Case: Terminate recursion.
    //Exclude nums[0] = 2:
    //Backtrack: cur = [2, 2].
    //Recursive call: backtrack(nums, 1, [2, 2], 1).
    //Include nums[1] = 3:
    //cur = [2, 2, 3], target = -2.
    //Base Case: Terminate recursion.
    //Exclude nums[1] = 3:
    //Backtrack: cur = [2].
    //Recursive call: backtrack(nums, 3, [2], 1).
    //Include nums[1] = 3:
    //cur = [2, 3], target = 0.
    //Base Case: Add [2, 3] to res.
    //Exclude nums[1] = 3:
    //Backtrack: cur = [].
    //Recursive call: backtrack(nums, 5, [], 1).
    //Include nums[1] = 3:
    //cur = [3], target = 2.
    //Recursive call: backtrack(nums, 2, [3], 1).
    //Include nums[1] = 3 again:
    //cur = [3, 3], target = -1.
    //Base Case: Terminate recursion.
    //Exclude nums[1] = 3:
    //Backtrack: cur = [].
    //<hr></hr>
    //Final Output:
    //res = [[2, 3]
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
