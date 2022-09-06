package array;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] arr){
        int n = arr.length;
        for (int i = n -1; i >= 0  ; i--) {
            if(arr[i] == 9){
                arr[i] = 0;
            }
            else
            {
                arr[i]++;
                return arr;
            }
        }
        arr = new int[n+1];
        arr[0] = 1;
        return arr;
    }
    public static void main(String[] args) {
     int[] a = {2,2,9};
     int[] b = {9,9,9};
     PlusOne plusOne = new PlusOne();
     int[] result = plusOne.plusOne(a);
       Arrays.stream(result).forEach(value -> System.out.println(value ));
    }
}
