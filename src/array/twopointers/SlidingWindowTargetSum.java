package array.twopointers;

      //   0,1,2,3,4,5,6,7,8,9,10
//Array - {6,-6,1,2,3,3,2,1,1,1,1,2,4}
//[[6], [6, -6, 1, 2, 3], [-6, 1, 2, 3, 3, 2, 1], [1, 2, 3], [3, 3], [3, 2, 1], [2, 1, 1, 1, 1], [1, 1, 1, 1, 2], [2, 4]]
//target sum = 6

import java.util.ArrayList;
import java.util.List;

//Expected output - {1,2,3} , {3,3} , {3,2,1} {2,1,1,1,1}
//{1,1,1,1,2}
//{2,4}
//
//
//O(n)
public class SlidingWindowTargetSum {


    private List<List<Integer>> findSequenceWithTargetSum(int[] a, int targetSum) {

        int start = 0;
        int sum = 0;
        List<List<Integer>> sequences = new ArrayList<>();
        for (int end = 0; end < a.length; end++) {

            sum = sum + a[end];
            while (start <= end && sum > targetSum){
                sum = sum - a[start++];
            }


            if(sum == targetSum){
                List<Integer> numbers = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    numbers.add(a[i]);
                }
                sequences.add(numbers);

                //start - end // those indexes number i need to print
            }
        }
        return sequences;
    }


    private List<List<Integer>> findSequenceWithTargetSumII(int[] a, int targetSum) {

        int start = 0;
        int sum = 0;
        List<List<Integer>> sequences = new ArrayList<>();
        for (int end = 0; end < a.length; end++) {
            sum = sum + a[end];
            while (start <= end && sum > targetSum){
                sum = sum - a[start++];
            }
            if(sum == targetSum){
                List<Integer> numbers = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    numbers.add(a[i]);
                }
                sequences.add(numbers);
                //start - end // those indexes number i need to print
            }
            if ((end == a.length-1 && a[start] < 0) || (a[start] < 0 && sum == targetSum) ) {
                end = start;
                start++;
                sum = 0;
            }

        }
        System.out.println(sequences);
        return sequences;
    }


    public static void main(String[] args) {

        int[] a = {6,-6,1,2,3,3,2,1,1,1,1,2,4};
        int targetSum = 6;
        SlidingWindowTargetSum slidingWindowTargetSum = new SlidingWindowTargetSum();
        slidingWindowTargetSum.findSequenceWithTargetSumII(a, targetSum);
    }



}
