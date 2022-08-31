package array.SortingAlgos;

import java.util.Arrays;

public class MeetingRooms {

    boolean canAttendMeetings(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i< intervals.length-1;i++)
        {
            if(intervals[i][1]>intervals[i+1][0])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals={{1,3},{4,6},{7,10},{15,18}};
        MeetingRooms mr= new MeetingRooms();
        if(mr.canAttendMeetings(intervals))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}
