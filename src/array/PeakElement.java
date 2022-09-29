package array;

public class PeakElement {
    /*A peak element is an element that is strictly greater than its neighbors.

    Given an integer array nums, find a peak element, and return its index.
    If the array contains multiple peaks, return the index to any of the peaks.
    You may imagine that nums[-1] = nums[n] = -∞.
    You must write an algorithm that runs in O(log n) time.
    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    Explanation: Your function can return either index number 1 where the peak element is 2,
     or index number 5 where the peak element is 6.
     */
    int findPeakElement(int[] arr)
    {
        return search(arr,0,arr.length-1);
    }

    int search(int[] arr,int l, int r)
    {
        if(l==r)
        {
            return l;
        }
        int mid=(l+r)/2;
        if(arr[mid] > arr[mid+1])
            return search(arr,l,mid);
        return search(arr,mid+1,r);
    }
//search(arr,4,6); mid =5 ; search(arr,4,5) mid =4 ;search(arr,5,5)
    public static void main(String[] args) {
        int[] nums={1,2,1,3,5,6,4};
        PeakElement peak = new PeakElement();
        int index= peak.findPeakElement(nums);
        System.out.println("Peak element at index "+ index + " & element is "+nums[index]);
    }
}
