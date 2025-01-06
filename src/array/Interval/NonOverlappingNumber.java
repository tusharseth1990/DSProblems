package array.Interval;

import java.util.Arrays;

public class NonOverlappingNumber {
//Input: intervals = [[1,2],[2,4],[1,4]]
    //sorted  intervals = [[1,2],[1,4],[2,4]]
//Output: 1
    public int eraseOverlapIntervalsNCSol(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                res++;
                prevEnd = Math.min(end, prevEnd);
            }
        }
        return res;
    }

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




    public static void main(String[] args) {
        int[][] intervals= {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals= {{1,2},{2,3}};
        NonOverlappingNumber n= new NonOverlappingNumber();
        System.out.println(n.eraseOverlapIntervalsNCSol(intervals));
    }

}
