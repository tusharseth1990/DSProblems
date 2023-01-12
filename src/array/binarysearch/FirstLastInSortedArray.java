package array.binarysearch;

public class FirstLastInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int firstNo = search(nums, target, true);
        if(firstNo == -1){
            return new int[]{-1,-1};
        }
        int lastNo = search(nums, target , false);
        return new int[]{firstNo, lastNo};
    }

    int search(int[] nums, int target, boolean firstIndex) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                if(firstIndex) {
                    if(mid == start || nums[mid-1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                }
                else {
                    if(mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }
            }
            else if(nums[mid] > target){
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
