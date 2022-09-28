package array.twopointers;

public class DutchNationalFlagProblem {
    //logic understanding
    //a[1..Lo-1] zeroes (red)
    //a[Lo..Mid-1] ones (white)
    //a[Mid..Hi] unknown
    //a[Hi+1..N] twos (blue)
    //if 0: swap low & mid, increase low & mid
    //if 1: inc mid
    //if 2: swap mid & high, decrement high

    static void sort(int arr[],int n)
    {
        int lo=0;
        int hi=arr.length-1;
        int mid=0,temp=0;
        while(mid<=hi)
        {
            switch(arr[mid])
            {
                case 0:{
                    temp=arr[mid];
                    arr[mid]=arr[lo];
                    arr[lo]=temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2:{
                    temp=arr[mid];
                    arr[mid]=arr[hi];
                    arr[hi]=temp;
                    hi--;
                    break;
                }
            }
        }
    }

    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = { 2,2,1,0,1,1,0,1,2, 1,2,0,0,0,1 };
        int arr_size = arr.length;
        sort(arr,arr_size);
        printArray(arr,arr_size);

    }
}
