package array.binarysearch;

import java.util.ArrayList;

public class FirstAndLastPositionsSortedArray {
    static ArrayList<Integer> find(int[] arr, int x) {
        int n = arr.length;

        // return index of first occurrence
        int first = search(arr, x, true);

        // return index of last occurrence
        int last = search(arr, x, false);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(first);
        res.add(last);
        return res;
    }

    static int search(int[] arr, int x, boolean findStart) {
        int n = arr.length;

        // Initialize low and high index
        int low = 0, high = n - 1;

        // Initialize the index
        int ind = -1;

        // Find occurrence of x
        while(low <= high) {

            // Find the mid index
            int mid = (low + high) / 2;

            // If x is equal to arr[mid]
            if(x == arr[mid]) {
                ind = mid;
                if(findStart)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            // If x is less than arr[mid],
            // then search in the left subarray
            else if(x < arr[mid])
                high = mid - 1;

                // If x is greater than arr[mid],
                // then search in the right subarray
            else
                low = mid + 1;
        }

        return ind;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        ArrayList<Integer> res = find(arr, x);
        System.out.println(res.get(0) + " " + res.get(1));
    }
}
