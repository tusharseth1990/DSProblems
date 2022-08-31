package array.slidingwindow;

public class SubArrayWithGivenSum {

    int subArraySum(int arr[],int n,int sum)
    {
       int currSum=arr[0];
       int start=0;
       for(int i=1;i<n;i++)
       {
           while(currSum>sum && start<i-1)
           {
               currSum=currSum-arr[start];
               start++;
           }
           if(currSum==sum)
           {
               int p=i-1;
               System.out.println("Sum found between the index "+start +" & " + p);
           }
           if(i<n)
           {
               currSum=currSum+arr[i];
           }
       }
       return 0;
    }



    public static void main(String[] args) {
        SubArrayWithGivenSum s= new SubArrayWithGivenSum();
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 38;
        s.subArraySum(arr,n,sum);
    }
}
