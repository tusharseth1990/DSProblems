package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {


    public int lastStoneWeight(int[] stones) {
        // Max heap (Java’s PriorityQueue is min-heap by default, so use reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Smash until one or none left
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // heaviest
            int stone2 = maxHeap.poll(); // 2nd heaviest

            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public int lastStoneWeightII(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue();
        for (int stone : stones) maxHeap.add(-stone);
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();
            if (stone1 != stone2) maxHeap.add(stone1 - stone2);
        }
        return maxHeap.size() != 0 ? (-maxHeap.remove()) : 0;
    }
}
