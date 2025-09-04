package graphs;
//DFS is a traversal technique which involves the idea of recursion and backtracking.
// DFS goes in-depth, i.e., traverses all nodes by going ahead, and when there are
// no further nodes to traverse in the current path, then it backtracks on the same path
// and traverses other unvisited nodes.
//

import java.util.ArrayList;

public class DFS {
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj,
                           ArrayList<Integer> ls) {

        //marking current node as visited
        vis[node] = true;
        ls.add(node);

        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //boolean array to keep track of visited vertices
        boolean[] vis = new boolean[V+1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DFS dfs = new DFS();
        ArrayList<Integer> ans = dfs.dfsOfGraph(5, adj);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    }
