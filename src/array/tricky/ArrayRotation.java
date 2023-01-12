package array.tricky;


public class ArrayRotation {

    void leftRotateByOne(int a[])
    {
        int temp =a[0];
        int i;
        for(i=0;i< a.length-1;i++)
        {
            a[i] = a[i+1];
        }
        a[i]= temp;

    }
    void rotateByDiff(int a[],int d)
    {
        if(d>a.length)
        {
            d = d-a.length;
        }
        for(int i=0;i<d ;i++)
        {
            leftRotateByOne(a);
        }
        System.out.println("Array elements after rotation");
        for(int arr:a )
        {
            System.out.print(arr);
        }

    }

    public static void main (String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        ArrayRotation ar = new ArrayRotation();
        ar.rotateByDiff(arr,1);
    }
}
