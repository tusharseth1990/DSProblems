package graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraphDFS {

    // Function to detect a cycle in a directed graph using DFS
    public static boolean hasCycle(int numNodes, List<List<Integer>> adj) {
        boolean[] visited = new boolean[numNodes]; // Tracks all visited nodes
        boolean[] recursionStack = new boolean[numNodes]; // Tracks nodes in the current DFS path

        // Iterate through all nodes to handle disconnected components
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recursionStack)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    // Recursive DFS helper function
    private static boolean dfs(int u, List<List<Integer>> adj, boolean[] visited, boolean[] recursionStack) {
        visited[u] = true; // Mark current node as visited
        recursionStack[u] = true; // Add current node to recursion stack

        // Explore all neighbors of the current node
        for (int v : adj.get(u)) {
            // If neighbor not visited, recursively call DFS
            if (!visited[v]) {
                if (dfs(v, adj, visited, recursionStack)) {
                    return true; // Cycle found in a sub-path
                }
            }
            // If neighbor is already in the recursion stack, a cycle is detected
            else if (recursionStack[v]) {
                return true;
            }
        }

        recursionStack[u] = false; // Remove current node from recursion stack (backtrack)
        return false; // No cycle found in this path
    }

    public static void main(String[] args) {
        // Example 1: Graph with a cycle (0 -> 1 -> 2 -> 0)
        int numNodes1 = 3;
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < numNodes1; i++) {
            adj1.add(new ArrayList<>());
        }
        adj1.get(0).add(1);
        adj1.get(1).add(2);
        adj1.get(2).add(0); // Cycle
        System.out.println("Graph 1 contains cycle? " + hasCycle(numNodes1, adj1)); // Expected: true

        // Example 2: Graph without a cycle (DAG)
        int numNodes2 = 4;
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < numNodes2; i++) {
            adj2.add(new ArrayList<>());
        }
        adj2.get(0).add(1);
        adj2.get(0).add(2);
        adj2.get(1).add(3);
        System.out.println("Graph 2 contains cycle? " + hasCycle(numNodes2, adj2)); // Expected: false
    }
}
