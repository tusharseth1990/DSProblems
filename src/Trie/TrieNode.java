package Trie;

public class TrieNode {

    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[R];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
