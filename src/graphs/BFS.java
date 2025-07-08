package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//1. Initialization: Enqueue the given source vertex into a queue and mark it as visited.
//2. Exploration: While the queue is not empty:
//  a) Dequeue a node from the queue and visit it (e.g., print its value).
//  b) For each unvisited neighbor of the dequeued node:
//  c) Enqueue the neighbor into the queue.
//  d) Mark the neighbor as visited.
//Termination: Repeat step 2 until the queue is empty.

//Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
//Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list

public class BFS {

    private ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it :
                    adj.get(node)) {
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }

        }
        return bfs;
    }

    public static void main(String[] args) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        BFS bfs = new BFS();
        ArrayList < Integer > ans = bfs.bfsOfGraph(5, adj);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.println(ans.get(i)+ " ");
        }

    }


}
