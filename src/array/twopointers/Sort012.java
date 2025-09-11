package array.twopointers;

import java.util.Arrays;

public class Sort012 {


    public void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] sortValues(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid <= high){
            switch (arr[mid]){
                case 0: swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;

                case 2: swap(arr,mid,high);
                    high--;
                    break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};

       Sort012 sort012 = new Sort012();
       int[] sortedArray = sort012.sortValues(arr);
        Arrays.stream(sortedArray).forEach(System.out::println);

    }

}
