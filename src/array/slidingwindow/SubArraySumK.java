package array.slidingwindow;

import java.util.HashMap;

public class SubArraySumK {

    int subArraySum(int arr[],int k)
    {
        int count=0,sum=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum-k))
            {
                count=count +hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr1[] = { 3,4,7,2,-3,1,4,2 };
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int k = 7;
        SubArraySumK s= new SubArraySumK();
        System.out.println(s.subArraySum(arr1,k));
        System.out.println(s.subArraySum(arr,38));
    }
}
