package greedy;

/*
Initialization://Breadth First Search (Greedy)
res: Counts the number of jumps ,   l and r: Represent the current window of indices that can be reached.
Iterate Until the Last Index:
While the right boundary (r) is less than the last index:
Calculate the farthest index that can be reached within the current window (l to r).
Update the window (l to r) to the next range of indices.
Increment the jump count (res).
Return Result: The total number of jumps (res) is returned
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int res = 0, l = 0, r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }
}
