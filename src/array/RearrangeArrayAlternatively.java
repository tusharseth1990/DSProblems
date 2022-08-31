package array;

public class RearrangeArrayAlternatively {

    static void rearrange(int arr[],int n)
    {

        int temp[]=arr.clone();
        int high=n-1;
        int low=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                arr[i]=temp[high--];
            }else{
                arr[i]=temp[low++];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5,8,3,9,0,2,7,6,4 };
        int n = arr.length;

        System.out.println("Original Array");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        rearrange(arr, n);

        System.out.print("\nModified Array\n");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

    }
}
