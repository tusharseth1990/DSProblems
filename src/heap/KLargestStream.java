package heap;

import java.util.PriorityQueue;

public class KLargestStream {
    private PriorityQueue<Integer> minHeap;
    private int k;
//m * log k , o(k) : space
    public KLargestStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
