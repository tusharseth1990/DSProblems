package array;

public class ProductExceptSelf {

    int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;
        int[] L= new int[n];
        int[] R= new int[n];
        int[] answer= new int[n];

        L[0]=1;
        for(int i=1;i<n;i++)
        {
            L[i]=nums[i-1]*L[i-1];
        }
        R[n-1]=1;
        for(int i=n-2;i>=0;i--)
        {
            R[i]=nums[i+1]*R[i+1];
        }

        for(int i=0;i<n;i++)
        {
            answer[i]=L[i]*R[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums={4,5,1,8,2};
        ProductExceptSelf prod= new ProductExceptSelf();
        int[] answer=prod.productExceptSelf(nums);
        for(int i:answer)
        {
            System.out.print(i + " ") ;
        }
    }
}
