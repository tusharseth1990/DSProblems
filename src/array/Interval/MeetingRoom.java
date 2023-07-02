package array.Interval;

import java.util.Arrays;
//Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
//
//
//
//Example 1:
//
//Input: intervals = [[0,30],[5,10],[15,20]]
//Output: false
//The idea here is to sort the meetings by starting time.
// Then, go through the meetings one by one and make sure that each meeting ends before the next one starts.

//Algo:
//SORT BY START TIME & THEN CHECK current right side of interval with current+1 left side of
// interval if it overlaps return false in the end return true.

public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
