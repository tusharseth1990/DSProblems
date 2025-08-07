package tries.hashmap;
/*
O(n): time , space : O(t) Where
n is the length of the string and t is the total number of TrieNodes created in the Trie.

Initial state (empty trie):
root: {}
Inserting "cat":
1. Start at root, process 'c':
root: {c → node1}
node1: {}
2. Process 'a':
root: {c → node1}
node1: {a → node2}
node2: {}
3. Process 't':
root: {c → node1}
node1: {a → node2}
node2: {t → node3}
node3: {endOfWord = true}
 */
public class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;                           // Start at root
        for (char c : word.toCharArray()) {            // For each char in word
            cur.children.putIfAbsent(c, new TrieNode());  // Create new node if char doesn't exist
            cur = cur.children.get(c);                    // Move to child node
        }
        cur.endOfWord = true;                         // Mark last node as word end
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
