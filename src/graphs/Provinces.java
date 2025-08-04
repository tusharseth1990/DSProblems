package graphs;

import java.util.ArrayList;

public class Provinces {

    //actual code
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = getAdjLs(adj, V);
        int vis[] = new int[V];
        int cnt = 0;
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                cnt++;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }

    // dfs traversal function
    private static void dfs(int node,
                            ArrayList<ArrayList<Integer>> adjLs ,
                            int[] vis) {
        vis[node] = 1;
        for(Integer it: adjLs.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adjLs, vis);
            }
        }
    }

    /*//converting adj matrix to adj list
      0 1 2
    0[1 0 1]
    1[0 1 0]
    2[1 0 1]

0 -> {2}
1 -> {}
2 -> {0}
    */
    private static ArrayList<ArrayList<Integer>> getAdjLs(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i = 0; i< V; i++) {
            adjLs.add(new ArrayList<>());
        }
        // to change adjacency matrix to list
        for(int i = 0; i< V; i++) {
            for(int j = 0; j< V; j++) {
                // self nodes are not considered
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        return adjLs;
    }

    public static void main(String[] args)
    {
      //0 1 2
    //0[1 0 1]
    //1[0 1 0]
    //2[1 0 1]
        // adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        Provinces ob = new Provinces();
        System.out.println(ob.numProvinces(adj,3));
    }

}
