package Trie;

import java.util.HashMap;

public class TNode {
    HashMap<Character, TNode> children = new HashMap<>();
    boolean endOfWord = false;
}
