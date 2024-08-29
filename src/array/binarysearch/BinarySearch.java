package array.binarysearch;

public class BinarySearch {

    int binarySearch(int arr[],int l,int r,int x)
    {
        if(l<=r)
        {
            // mid is calculated this way to prevent integer overflow.
            int mid= l+(r-l)/2;
            if(arr[mid]==x)
            {
                return mid;
            }
            if(arr[mid]>x)
            {
                return binarySearch(arr,l,mid-1,x);
            }
            else{
                return binarySearch(arr,mid+1,r,x);
            }
        }
        return -1;
    }

    int binarySearchIterative(int arr[], int x)
    {
       int l=0, r= arr.length-1;
       while(l<=r)
       {
           int mid=l+(r-l)/2;
           if(arr[mid]==x)
           {
               return mid;
           }
           else if(arr[mid]>x)
           {
               r=mid-1;
           }
           else{
               l=mid+1;
           }

       }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);
        System.out.println("recursive binary search");

        int res= ob.binarySearchIterative(arr,x);
        if (res == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);
    }
}
