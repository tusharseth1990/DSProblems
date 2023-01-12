package array.tricky;

public class UnionAndIntersection {

    static void printUnion(int arr1[],int arr2[],int m,int n)
    {
        int i=0,j=0;
        while(i<m && j<n)
        {
            if(arr1[i] < arr2[j])
            {
                System.out.println(arr1[i++]);
            }
            else if(arr1[i] > arr2[j])
            {
                System.out.println(arr2[j++]);
            }
            else{
                System.out.println(arr1[i++]);
                j++;
            }
        }
        while(i<m)
        {
            System.out.println(arr1[i++]);
        }
        while(j<n)
        {
            System.out.println(arr2[j++]);
        }
    }//O(m+n)

    static void printIntersection(int arr1[],int arr2[],int m, int n)
    {
        int i=0,j=0;
        while(i<m && j<n)
        {
            if(arr1[i] < arr2[j])
            {
                i++;
            }
            else if(arr1[i] > arr2[j])
            {
                j++;
            }
            else{
                System.out.println(arr1[i++]);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 4, 5, 6 };
        int arr2[] = { 2, 3, 5, 7 };
        int m = arr1.length;
        int n = arr2.length;
        //printUnion(arr1, arr2, m, n);
        printIntersection(arr1,arr2,m,n);
    }
}
