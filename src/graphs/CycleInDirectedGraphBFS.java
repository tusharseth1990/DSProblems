package graphs;

import java.util.*;

public class CycleInDirectedGraphBFS {

    /**
     * Detects if a directed graph contains a cycle using BFS (Kahn's Algorithm).
     *
     * @param V The number of vertices in the graph.
     * @param adj An adjacency list representing the graph where adj[i] contains
     *            a list of neighbors of vertex i.
     * @return true if a cycle is detected, false otherwise.
     */
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];

        // Calculate in-degrees for all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // To count processed vertices

        // Process vertices from the queue
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            // For each neighbor, decrease its in-degree
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                // If a neighbor's in-degree becomes 0, add it to the queue
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If the number of processed vertices is not equal to the total number of vertices,
        // it means a cycle exists (not all vertices could be included in a topological sort).
        return count != V;
    }

    public static void main(String[] args) {
        // Example Usage:
        // Graph with a cycle: 0 -> 1, 1 -> 2, 2 -> 0
        List<List<Integer>> graphWithCycle = new ArrayList<>();
        graphWithCycle.add(Arrays.asList(1)); // 0 -> 1
        graphWithCycle.add(Arrays.asList(2)); // 1 -> 2
        graphWithCycle.add(Arrays.asList(0)); // 2 -> 0
        int V1 = 3;

        CycleInDirectedGraphBFS detector = new CycleInDirectedGraphBFS();
        System.out.println("Graph with cycle: " + detector.hasCycle(V1, graphWithCycle)); // true

        // Graph without a cycle: 0 -> 1, 0 -> 2, 1 -> 3
        List<List<Integer>> graphWithoutCycle = new ArrayList<>();
        graphWithoutCycle.add(Arrays.asList(1, 2)); // 0 -> 1, 0 -> 2
        graphWithoutCycle.add(Arrays.asList(3));    // 1 -> 3
        graphWithoutCycle.add(new ArrayList<>());   // 2 has no outgoing edges
        graphWithoutCycle.add(new ArrayList<>());   // 3 has no outgoing edges
        int V2 = 4;

        System.out.println("Graph without cycle: " + detector.hasCycle(V2, graphWithoutCycle)); // false
    }
}
