package array.slidingwindow;

public class MaxProductSubArray {

    static int maxProduct(int[] arr)
    {
        if(arr.length==0)
            return 0;

        int max_so_far=arr[0];
        int min_so_far=arr[0];
        int result =max_so_far;

        for(int i=1;i<arr.length;i++)
        {
            int curr=arr[i];

            int temp_max=Math.max(curr,Math.max(max_so_far*curr,min_so_far*curr));
            min_so_far=Math.min(curr,Math.min(max_so_far*curr,min_so_far*curr));
            max_so_far=temp_max;
            result=Math.max(max_so_far,result);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[]={-4,-3,-2};
        int p= maxProduct(arr);
        System.out.println("Max Product SubArray is "+ p);
    }
}
