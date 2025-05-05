package array.Interval;

import java.util.ArrayList;
import java.util.List;
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Greedy Approach

//complexity : time : o(n)
//https://leetcode.com/problems/insert-interval/
//we are iterating intervals and comparing each current interval with new interval.
// 3 condition : either it will come before the current interval , after the interval  or
//To check overlapping if below conditions are false,
// condition 1: right value of old interval should be less than new interval left value
//condition 2: left value of new interval should be greater than the right value of old interval
//these two will overlap so we will get minimum of left side of newInterval & curr Interval and
//max of right side of newInterval & curr Interval
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0])
                res.add(interval);
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

    }

}
