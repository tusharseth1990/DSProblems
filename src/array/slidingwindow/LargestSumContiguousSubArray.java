package array.slidingwindow;

public class LargestSumContiguousSubArray {

    //Kadane algo

    static int maxSubArraySum(int arr[])
    {
        int n=arr.length;
        int max_so_far=Integer.MIN_VALUE;
        int curr_sum=0;
        for(int i=0;i<n;i++)
        {
            curr_sum=curr_sum+arr[i];
            if(curr_sum>max_so_far)
            {
                max_so_far=curr_sum;
            }
            if(curr_sum<0)
            {
                curr_sum=0;
            }
        }
        return max_so_far;
    }

    static int maxSubArray(int[] arr)
    {
        int current=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int num=arr[i];
            current=Math.max(num,current+num);
            max=Math.max(max,current);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSumContiguousSubArray s=new LargestSumContiguousSubArray();
        int [] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
        System.out.println("Maximum contiguous sum is " +
                maxSubArray(a));
    }
}
