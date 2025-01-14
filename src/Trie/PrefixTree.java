package Trie;

public class PrefixTree {
    private TNode root;

    public PrefixTree() {
        root = new TNode();
    }

    public void insert(String word) {
        TNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }



}
