package array.slidingwindow;

import java.util.HashSet;
import java.util.*;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
public class TripletsWithGivenSum {

    static void findTriplets(int[] arr,int n, int sum)
    {
        for(int i=0;i<n-1;i++)
        {
            HashSet<Integer> s= new HashSet<>();

            for(int j=i+1;j<n;j++)
            {
                int x=sum-(arr[i] + arr[j]);
                if(s.contains(x))
                {
                    System.out.printf("%d %d %d \n",x,arr[i],arr[j]);

                }
                else{
                    s.add(arr[j]);
                }
            }
        }
    }

   static List<List<Integer>> threeSum(int[] nums)
    {
        Set<List<Integer>> res=new HashSet<>();
        Set<Integer> t=new HashSet<>();
        Map<Integer,Integer> seen= new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(t.add(nums[i]))
            {
                for(int j=i+1;j< nums.length;j++)
                {
                    int complement =-nums[i]-nums[j];
                    if(seen.containsKey(complement) && seen.get(complement) == i)
                    {
                        List<Integer> triplet= Arrays.asList(nums[i],nums[j],complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList(res);
    }

    public static void main(String[] args) {
        int arr[] = { -1,0,1,2,-1,-4 };
        int sum = 0;
        int n = arr.length;
        //findTriplets(arr, n, sum);
        System.out.println(threeSum(arr));
    }
}
