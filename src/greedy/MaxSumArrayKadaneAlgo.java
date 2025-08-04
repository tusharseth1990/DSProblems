package greedy;
//brute force o(n^3)

// o(n) : KADEN ALGORITHM
public class MaxSumArrayKadaneAlgo {

    public int maxSubArray(int[] nums) {
        int maxSub = nums[0], curSum = 0;
        for (int num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }
}
