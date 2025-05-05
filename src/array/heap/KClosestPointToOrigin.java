package array.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

//K Closest Points to Origin
//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
// and an integer k, return the k closest points to the origin (0, 0).
//
// The distance between two points on the X-Y plane is the Euclidean distance
// (i.e., √(x1 - x2)2 + (y1 - y2)2).
//
// You may return the answer in any order. The answer is guaranteed to be
// unique (except for the order that it is in).
//
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//        Output: [[3,3],[-2,4]]
//        Explanation: The answer [[-2,4],[3,3]] would also be accepted.
public class KClosestPointToOrigin {
//min heap : time : k log n , space : n
//use this
    public int[][] kClosestNC(int[][] points, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; ++i) {
            int[] point = minHeap.poll();
            result[i] = new int[]{point[1], point[2]};
        }
        return result;
    }

    //max heap,  time: n * log k, space : k

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],
                        a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }
        return res;
    }
}
