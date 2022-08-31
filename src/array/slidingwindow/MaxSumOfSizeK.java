package array.slidingwindow;

public class MaxSumOfSizeK {

    int maxSubArraySum(int arr[],int n,int k)
    {
        if(n<k)
        {
            System.out.println("Invalid");
        }
        int curr_sum=Integer.MIN_VALUE;
        int max_sum=0;
        for(int i=0;i<k;i++)
        {
            max_sum+=arr[i];
        }
        curr_sum=max_sum;
        for(int i=k;i<n;i++)
        {
            curr_sum=curr_sum+arr[i]-arr[i-k];
            max_sum=Math.max(curr_sum,max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        MaxSumOfSizeK s= new MaxSumOfSizeK();
        int arr[]={1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k=4;
        int n=arr.length;
        System.out.println("Max sum of size "+k);
        System.out.println(s.maxSubArraySum(arr,n,k));
    }
}
