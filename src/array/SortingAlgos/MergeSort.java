package array.SortingAlgos;

public class MergeSort {

    void merge(int arr[],int l, int m,int r)
    {
        int n1=m-l+1;
        int n2=r-m;
        int left[]=new int[n1];
        int right[]=new int[n2];
        for(int i=0;i<n1;i++)
        {
            left[i]=arr[l+i];
        }
        for(int j=0;j<n2;j++)
        {
            right[j]=arr[m+j+1];
        }
        int i=0,j=0;
        int k=l;
        while(i<n1 && j<n2)
        {
            if(left[i]>=right[j])
            {
                arr[k]=right[j];
                j++;
            }
            else
            {
                arr[k]=left[i];
                i++;
            }
            k++;
        }

        while(i<n1)
        {
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k]=right[j];
            j++;
            k++;
        }

    }

    static void printArray(int arr[])
    {
        for(int i:arr)
        {
            System.out.println(i);
        }
    }


  void sort(int arr[],int l,int r)
  {
      if(l<r)
      {
          int m=l+(r-l)/2;
          sort(arr,l,m);
          sort(arr,m+1,r);
          merge(arr,l,m,r);
      }
  }

    public static void main(String[] args) {

        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr,0,arr.length-1);
        System.out.println("After Sorting");
        MergeSort.printArray(arr);
    }
}
