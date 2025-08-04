package greedy;
/*
Goal Initialization: Start with the last index as the target (goal).
Iterate Backwards: Traverse the array from the second-to-last index to the first.
Check Reachability: For each index, check if the current index plus its value can reach or exceed the goal.
If yes, update the goal to the current index.
Final Check: If the goal is updated to 0, it means the first index can reach the last index, so return true.
Otherwise, return false.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
