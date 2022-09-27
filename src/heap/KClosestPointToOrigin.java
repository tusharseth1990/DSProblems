package heap;


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

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->
                Integer.compare(
                        (a[0] * a[0] + a[1] * a[1]),
                        (b[0] * b[0] + b[1] * b[1])
                )
        );
        for (int[] point : points) {
            q.add(point);
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = q.poll();
            ans[i][0] = cur[0];
            ans[i][1] = cur[1];
        }
        return ans;
    }
}
