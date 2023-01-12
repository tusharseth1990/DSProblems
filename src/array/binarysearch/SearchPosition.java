package array.binarysearch;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [1,3,5,6], target = 5
Output: 2
Input: nums = [1,3,5,6], target = 2
Output: 1
 */
public class SearchPosition {

    int searchInsertPosition(int[] arr,int x)
    {
        int l=0,r= arr.length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]==x)
            {
                return mid;
            }
            else if(arr[mid]>x)
            {
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,6};
        SearchPosition sp=new SearchPosition();
        int index=sp.searchInsertPosition(arr,7);
        System.out.println("Element found at index or should be at index "+index);
    }
}
