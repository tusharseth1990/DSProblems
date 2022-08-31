package array;

/*
Given an array of n integers where each value represents the number of chocolates in a packet.
Each packet can have a variable number of chocolates. There are m students,
the task is to distribute chocolate packets such that:
Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and
packet with minimum chocolates given to the students is minimum
 */


import java.util.Arrays;

public class ChocolateDistribution {

    /*Approach
     to minimize the difference, we must choose consecutive elements from a sorted packet. We first sort the array arr[0..n-1],
     then find the subarray of size m with the minimum difference between the last and first elements.
     */

    //O(NLogN)
    static int findMinDiff(int arr[],int m, int n)
    {
        if(m==0 || n==0)
        {
            return 0;
        }
        if(n<m)
        {
            return 0;
        }
        Arrays.sort(arr);
        int min_diff=Integer.MAX_VALUE;
        for(int i=0;i+m-1<n;i++)
        {
            int diff=arr[i+m-1]-arr[i];
            min_diff=Math.min(min_diff,diff);
        }
        return min_diff;
    }

    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23,
                25, 41, 30, 40, 28,
                42, 30, 44, 48, 43,
                50};
        int m=7;
        int n= arr.length;;
        System.out.println("Minimum difference is "
                + findMinDiff(arr, m,n));
    }
}
