package array.SortingAlgos;

import java.util.Arrays;

public class BubbleSort {

    void bubbleSort(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

        }
        System.out.println("Sorted array is");
        for(int i:arr)
        {
            System.out.println(i);
        }
    }

    static void recursiveBubbleSort(int arr[],int n)
    {
        if(n==1)
        {
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]>arr[i+1])
            {
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        recursiveBubbleSort(arr,n-1);
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        //sort.bubbleSort(arr);
        recursiveBubbleSort(arr,arr.length-1);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
    }
}
