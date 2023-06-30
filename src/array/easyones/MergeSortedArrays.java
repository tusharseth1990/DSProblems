package array.easyones;

public class MergeSortedArrays {

    void mergeSortedArraysWithDifferentLength(int[] a, int m, int[] b, int n)
    {
        int i=0,j=0;
        while(i<m && j<n)
        {
            if(a[i]<=b[j])
            {
                System.out.println(a[i]);
                i++;
            } else  {
                System.out.println(b[j]);
                j++;
            }

        }
        while (i<m)
        {
            System.out.println(a[i]);
            i++;
        }
        while (j<n)
        {
            System.out.println(b[j]);
            j++;
        }
    }


    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={2,5,6};

        MergeSortedArrays ms= new MergeSortedArrays();
        ms.mergeSortedArraysWithDifferentLength(arr1,arr1.length,arr2, arr2.length);
    }
}
