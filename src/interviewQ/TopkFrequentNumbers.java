package interviewQ;
//[1,2,2,3,3,3,4,4,4,4]
//
//top 2 frequent number
//
//[4,3]

import java.util.*;

//
//
public class TopkFrequentNumbers {

    private static int[] topKFrequency(int[] nums, int k) {
        //base case
        if(k == nums.length){
            return nums;
        }
        Map<Integer,Integer> count = new HashMap<>();
        for (int n :
                nums) {
            count.put(n, count.getOrDefault(n,0)+1);
        }
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparing(count::get));

        for (int n:
                count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] top = new int[k];

        for (int i = k-1; i >=0; i--) {
            top[i] = heap.poll();
        }

        return top;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,3,4,4,4,4};
        int k = 2;
        int[] result = topKFrequency(a, k);
        Arrays.stream(result).forEach(num -> System.out.println(num));
    }


}
