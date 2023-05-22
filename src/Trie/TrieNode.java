package Trie;
//Trie (we pronounce "try") or prefix tree is a tree data structure, which is used
// for retrieval of a key in a dataset of strings. There are various applications
// of this very efficient data structure such as :

//1. Autocomplete
//2. Spell checker
//3. IP routing (Longest prefix matching)
//4. T9 predictive text(T9 which stands for Text on 9 keys, was used on phones to input texts during the late 1990s.)
//5. Solving word games

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
