package array.twopointers;

public class RemoveDuplicateFromSortedArray {
//Input: nums = [1,1,2,3,4]
//
//Output: [1,2,3,4]
    public int removeDuplicates(int[] nums) {
        int l = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[r - 1]) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }
}
