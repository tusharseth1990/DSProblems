package heap;

import java.util.PriorityQueue;
import java.util.Queue;
// Small Heap ==> will use Max heap to get max element at O(1)
// Large Heap ==> will use Min heap to get min element at O(1)
// AlWays we enter the elements in the small heap
// then check Small Heap's max element < Large Heap min element
// Add/remove the elements from the heap at O(log n) when need to rebalance the elements
// The size difference should be always not more than 1 , if more we need to rebalance it

public class FindMedianFromDataStream {

    private Queue<Integer> smallHeap; //small elements - maxHeap
    private Queue<Integer> largeHeap; //large elements - minHeap

    public FindMedianFromDataStream() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    // Adding always to the small heap
    public void addNum(int num) {
        smallHeap.add(num);
        // if size >1  or then check Small Heap's max element < Large Heap min element
        if (
                smallHeap.size() - largeHeap.size() > 1 ||
                        !largeHeap.isEmpty() &&
                                smallHeap.peek() > largeHeap.peek()
        ) {
            // remove from small heap & put into large heap
            largeHeap.add(smallHeap.poll());
        }
        // if again after adding it needs a rebalancing
        // then add in the small heap
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }

    //if size is same then small heap ka max element & Large heap ka min element ko divide by 2
    //if small heap is bigger then take max element of small heap
    //if large heap is bigger then take min element of large heap
    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        } else if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else {
            return (double) largeHeap.peek();
        }
    }
}
