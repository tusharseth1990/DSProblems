package array.Interval;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//Given an array of meeting time intervals where intervals[i] = [starti, endi],
// determine if a person could attend all meetings.
//
//Input: intervals = [[0,30],[5,10],[15,20]]  : Output: false
//The idea here is to sort the meetings by starting time.
// Then, go through the meetings one by one and make sure that each meeting ends before the next one starts.
//Algo:
//SORT BY START TIME & THEN CHECK current right side of interval with current+1 left side of
// interval if it overlaps return false in the end return true.

public class MeetingRoom {

    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }

    public boolean canAttendMeetings(int[][] intervals) {
      //  Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }




}
