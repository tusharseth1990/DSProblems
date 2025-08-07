package tries.array;
/*
O(n): time , space : O(t) Where
n is the length of the string and t is the total number of TrieNodes created in the Trie.

Dry Run:
Initial state:
root: [null, null, null, ... null] (26 slots for a-z)
Inserting "cat":
1. Process 'c' (index = 2):
   i = 'c' - 'a' = 2
root: [null, null, node1, null, ... null]
node1: [null, null, null, ... null]
2. Process 'a' (index = 0):
   i = 'a' - 'a' = 0
root: [null, null, node1, null, ... null]
node1: [node2, null, null, ... null]
node2: [null, null, null, ... null]
3. Process 't' (index = 19):
   i = 't' - 'a' = 19
root: [null, null, node1, null, ... null]
node1: [node2, null, null, ... null]
node2: [null, null, null, ... node3, ... null]
node3: {endOfWord = true}
 */

public class PrefixTree {

    private TrieNode root;

    public PrefixTree(){
        root = new TrieNode();
    }

    /*
    Uses fixed-size array of 26 slots (a-z)
Calculates index using c - 'a' (e.g., 'c' - 'a' = 2)
More memory efficient for English lowercase letters
Direct array access is faster than HashMap lookups
Each node's children array holds references to child nodes at indices corresponding to letters (a=0, b=1, c=2, etc
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }
        return true;
    }
}
