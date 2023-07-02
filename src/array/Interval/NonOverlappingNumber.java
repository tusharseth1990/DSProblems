package array.Interval;

import java.util.Arrays;

public class NonOverlappingNumber {

    public int eraseOverlapIntervals(int[][] intervals) {
        int intervalsRemoved = 0;

        Arrays.sort(
                intervals,
                (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])
        );

        int[] intervalFirst = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (firstIntervalwithinSecond(intervalFirst, intervals[i])) {
                //mark first interval to be removed
                intervalsRemoved++;
                // determine which interval to remove
                //remove the interval that ends last
                if (intervalFirst[1] > intervals[i][1]) {
                    intervalFirst = intervals[i];
                }
            } else {
                intervalFirst = intervals[i];
            }
        }
        return intervalsRemoved;
    }

    public boolean firstIntervalwithinSecond(
            int[] intervalFirst,
            int[] intervalSecond
    ) {
        return intervalSecond[0] < intervalFirst[1];
    }


    public int eraseOverlapIntervalsII(int[][] intervals) {
        int intervalsRemoved = 0;

        Arrays.sort(
                intervals,
                (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])
        );

        int[] intervalFirst = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]< intervalFirst[1]) { //firstIntervalwithinSecond
                //mark first interval to be removed
                intervalsRemoved++;
                // determine which interval to remove
                //remove the interval that ends last
                if (intervalFirst[1] > intervals[i][1]) {
                    intervalFirst = intervals[i];
                }
            } else {
                intervalFirst = intervals[i];
            }
        }
        return intervalsRemoved;
    }

    public static void main(String[] args) {
        //int[][] intervals= {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals= {{1,2},{2,3}};
        NonOverlappingNumber n= new NonOverlappingNumber();
        System.out.println(n.eraseOverlapIntervalsII(intervals));
    }
}
