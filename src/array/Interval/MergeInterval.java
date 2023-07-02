package array.Interval;

import java.util.Arrays;
import java.util.LinkedList;
//Input: intervals = [[1,3],[8,10],[15,18],[2,6]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//https://leetcode.com/problems/merge-intervals/

//Logic:
//sort the intervals wrt the start time
//Iterate over the intervals & take a resultant intervals Linked list to maintain order
//for the first iteration add the first interval (the result is empty till now)
//check the merged interval & curr interval are not overlapping
// [1,3] ,[5,6]
//i.e. check 3<5
//simply add the interval
//else overlapping condition
//[1,3][2,6]
//i.e. 3<2 not true (else)
//Take maximum of second item(end time) in the intervals


public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
