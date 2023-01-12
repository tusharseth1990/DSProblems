package array.tricky;

public class CountZeroOneTwo {

    private static void sortArr(int[] arr, int n) {
        int c0 = 0, c1 = 0, c2 = 0;
        int i;
        for (i = 0; i < arr.length; i++) {

            switch (arr[i]){
                case 0: c0++;
                break;
                case 1: c1++;
                break;
                case 2: c2++;
                break;
            }
        }
        i = 0;
        while(c0 > 0){
            arr[i++] = 0;
            c0--;
        }

        while(c1 > 0){
            arr[i++] = 1;
            c1--;
        }

        while(c2 > 0){
            arr[i++] = 2;
            c2--;
        }

        for (int j = 0; j <arr.length; j++) {
            System.out.println(arr[j] + " ");
        }
    }

    // Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
    static void sort012(int a[], int arr_size) {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        // Iterate till all the elements
        // are sorted
        while (mid <= hi) {
            switch (a[mid]) {
                // If the element is 0
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                // If the element is 1
                case 1:
                    mid++;
                    break;
                // If the element is 2
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int n = arr.length;
        sortArr(arr, n);
    }


}
