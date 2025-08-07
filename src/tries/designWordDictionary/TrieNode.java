package tries.designWordDictionary;

public class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }

}
