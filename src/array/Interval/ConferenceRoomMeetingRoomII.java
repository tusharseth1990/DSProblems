package array.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ConferenceRoomMeetingRoomII {

//two pointer
    public int minMeetingRooms1(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }

        int len = intervals.size();
        int[] startTime = new int[len];
        int[] endTime = new int[len];

        for (int i = 0; i < len; i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int res = 0;
        int count = 0;
        int s = 0;
        int e = 0;

        while (s < len) {
            if (startTime[s] < endTime[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }

        return res;
    }

    public int minMeetingRooms2(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)->(a.start-b.start));
        PriorityQueue<Interval> pq=new PriorityQueue<>((a, b)->(a.end-b.end));
        for(Interval i:intervals){
            if(!pq.isEmpty()&&pq.peek().end<=i.start){
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] intervals={{0,30},{5,10},{15,20}};
        List<Interval> ls = new ArrayList<>();
        Interval i1= new Interval(0,30);
        ls.add(i1);
        Interval i2 =new Interval(5,10);
        ls.add(i2);
        Interval i3 =new Interval(15,20);
        ls.add(i3);

        ConferenceRoomMeetingRoomII m= new ConferenceRoomMeetingRoomII();
        System.out.println(m.minMeetingRooms1(ls));
    }

}
