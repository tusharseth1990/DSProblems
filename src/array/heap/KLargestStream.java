package array.heap;
//Design a class to find the kth largest element in a stream.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
//        Implement KthLargest class:
//        KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
//        int add(int val) Appends the integer val to the stream and returns the element
//        representing the kth largest element in the stream.

//time : O(m * log k), space : O(k)
// add : log (n)
// pop : (n -k) log n
import java.util.PriorityQueue;

public class KLargestStream {
    private static int k;
    private PriorityQueue<Integer> minHeap;

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
