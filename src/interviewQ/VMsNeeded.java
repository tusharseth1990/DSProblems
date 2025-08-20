package interviewQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class VMsNeeded {
    //Suppose multiple jobs are running , each of job is needing separate VM to run
    // start time , end time , job name
    // sort by start time
    // J1 :{9,10}
    //J2 : {8,11}
    //J3 : {1,3};

    //{1,3} , {8,11} , {9,10}
    //both start & end time  sorted
    // 1 , 8, 9
    // 3 , 10, 11
    //Two pointer
    // 0 1 , 2

    //3 //3

    // deadlock
    // race condition
    // concurrency  :
    //  resource startation
    // Increasing complexity //
    //

    public int noOfVMsNeeded(List<Job> jobs) {
        if (jobs.isEmpty()) {
            return 0;
        }

        int size = jobs.size();
        Long[] startTime = new Long[size];
        Long[] endTime = new Long[size];

        for (int i = 0; i < size; i++) {
            startTime[i] = jobs.get(i).getStartTime();
            startTime[i] = jobs.get(i).getEndTime();
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int output = 0;
        int count = 0;
        int left = 0, right = 0;

        while (left < size) {
            if (startTime[left] < endTime[right]) {
                left++;
                count++;
            } else {
                count--;
                right++;
            }
            output = Math.max(output, count);
        }
        return output;
    }
}
