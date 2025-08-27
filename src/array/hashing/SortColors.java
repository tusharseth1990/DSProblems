package array.hashing;

public class SortColors {
//Dutch National Flag.
    //The problem is similar to "Segregate 0s and 1s in an array".
    // The idea is to sort the array of size n using three pointers: lo = 0, mid = 0 and hi = n - 1 such that
    // the array is divided into 4 parts -
    //
    //arr[0 .. lo - 1] → All 0s
    //arr[lo .. mid - 1] → All 1s
    //arr[mid .. hi] → Unprocessed elements (unknown)
    //arr[hi + 1 .. n - 1] → All 2s

    static void sort012(int[] arr) {
        int n = arr.length;

        // initialize three pointers:
        // lo: boundary for 0s
        // mid: current element being checked
        // hi: boundary for 2s
        int lo = 0;
        int hi = n - 1;
        int mid = 0;

        // process elements until mid crosses hi
        while (mid <= hi) {
            if (arr[mid] == 0) {

                // current is 0: swap with lo and move both
                // pointers forward
                int temp = arr[lo];
                arr[lo++] = arr[mid];
                arr[mid++] = temp;
            } else if (arr[mid] == 1) {
                // current is 1: it's already in correct position
                mid++;
            } else {
                // current is 2: swap with hi and move hi backward
                // do not increment mid, as swapped value needs
                // to be re-checked
                int temp = arr[mid];
                arr[mid] = arr[hi];
                arr[hi--] = temp;
            }
        }
    }


    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }


}
