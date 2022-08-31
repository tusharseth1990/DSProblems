package array.SortingAlgos;


import java.util.*;


// https://leetcode.com/problems/merge-intervals/solution/

public class MergeIntervals {

    int[][] mergeInterval(int[][] intervals)
    {
      //  Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        LinkedList<int[]> merged= new LinkedList<>();
        for(int[] interval:intervals)
        {
            if(merged.isEmpty() || merged.getLast()[1]<interval[0])
            {
                merged.add(interval);
            }
            else{
                merged.getLast()[1]= Math.max(merged.getLast()[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }

    public static void main(String[] args) {
        int[][] intervals={{8,10},{1,3},{2,6},{15,18}};
        MergeIntervals merge = new MergeIntervals();
        int[][] result=merge.mergeInterval(intervals);
        for(int[] row:result)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}
