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


    public int[] productExceptSelfII(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
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
