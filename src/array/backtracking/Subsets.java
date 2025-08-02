package array.backtracking;

import java.util.ArrayList;
import java.util.List;
/*Dry Run Logic for subsetsSol Method:
Input: An array nums = [1, 2, 3].
Goal: Generate all possible subsets of the array.

Initialization:
res is an empty list to store all subsets.
subset is an empty list to store the current subset during recursion.

Recursive Function (dfs):
The function explores two decisions at each index i:
Include the current element nums[i] in the subset. & then Exclude the current element nums[i] from the subset.
Base Case: When i equals the length of nums, the recursion stops, and the current subset is added to res.
 */
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


/*Dry Run Example:
Input: nums = [1, 2]
Initial Call: dfs(nums, 0, [], res)

i = 0, subset = [].
Include nums[0] = 1:
subset = [1].
Recursive call: dfs(nums, 1, [1], res).
Include nums[1] = 2:
subset = [1, 2].
Recursive call: dfs(nums, 2, [1, 2], res).
Base Case: Add [1, 2] to res.
Exclude nums[1] = 2:
Backtrack: subset = [1].
Recursive call: dfs(nums, 2, [1], res).
Base Case: Add [1] to res.
Exclude nums[0] = 1:
Backtrack: subset = [].
Recursive call: dfs(nums, 1, [], res).
Include nums[1] = 2:
subset = [2].
Recursive call: dfs(nums, 2, [2], res).
Base Case: Add [2] to res.
Exclude nums[1] = 2:
Backtrack: subset = [].
Recursive call: dfs(nums, 2, [], res).
Base Case: Add [] to res.
<hr></hr>
Final Output:
res = [[1, 2], [1], [2], []].  This logic can be extended for larger arrays.

 */

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
