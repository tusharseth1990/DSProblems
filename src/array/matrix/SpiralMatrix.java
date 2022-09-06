package array.matrix;

public class SpiralMatrix {

    static void spiralPrint(int m, int n,int arr[][])
    {
        int i,k=0,l=0;
        /*
        k - starting row index
        m-ending row index
        l-starting col index
        n- ending col index

        think as 4 loops in the different directions
         */
        while(k<m && l<n)
        {
            for(i=l;i<n;i++)
            {
                System.out.print(arr[k][i] + " ");
            }
            k++;

            for(i=k;i<m;i++)
            {
                System.out.print(arr[i][n-1] + " ");
            }
            n--;

            if(k<m)
            {
                for(i=n-1;i>=l;i--)
                {
                    System.out.print(arr[m-1][i] + " ");
                }
            }
            m--;

            if(l<n)
            {
                for(i=m-1;i>=k;i--)
                {
                    System.out.print(arr[i][l]+ " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = { { 1, 2, 3, 4, 5, 6 },
                    { 7, 8, 9, 10, 11, 12 },
                    { 13, 14, 15, 16, 17, 18 } };
        System.out.println(a.length);
        System.out.println(a[0].length);
        spiralPrint(R,C,a);
    }
}
