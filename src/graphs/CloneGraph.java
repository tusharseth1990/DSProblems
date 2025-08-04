package graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Space Complexity: O(N)O(N)O(N). This space is occupied by the visited hash map and in addition to that, space would also be occupied by the recursion stack since we are adopting a recursive approach here. The space occupied by the recursion stack would be equal to O(H)O(H)O(H) where HHH is the height of the graph. Overall, the space complexity would be O(N)O(N)O(N)
//Time Complexity: O(N+M)O(N + M)O(N+M), where NNN is a number of nodes (vertices) and MMM is a number of edges.
public class CloneGraph {


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
//Solution
    class Solution {
        private HashMap <Node, Node> visited = new HashMap <> ();
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }

            // If the node was already visited before.
            // Return the clone from the visited dictionary.
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            // Create a clone for the given node.
            // Note that we don't have cloned neighbors as of now, hence [].
            Node cloneNode = new Node(node.val, new ArrayList<>());
            // The key is original node and value being the clone node.
            visited.put(node, cloneNode);

            // Iterate through the neighbors to generate their clones
            // and prepare a list of cloned neighbors to be added to the cloned node.
            for (Node neighbor: node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }
}
