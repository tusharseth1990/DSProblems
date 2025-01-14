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

public class KLargest {
    private static int k;
    private PriorityQueue<Integer> minHeap;

    public KLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num: nums) {
            minHeap.add(num);
        }

    }

    public int add(int val) {
        // Add to our minHeap if we haven't processed k elements yet
        // or if val is greater than the top element (the k-th largest)
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }

}
