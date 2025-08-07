package tries.hashmap;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}
