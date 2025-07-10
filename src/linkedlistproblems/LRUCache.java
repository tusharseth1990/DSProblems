package linkedlistproblems;


import java.util.HashMap;
import java.util.Map;
//LRUCache(int capacity) Initialize the LRU cache of size capacity.
//int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists.
// Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the
// cache to exceed its capacity, remove the least recently used key.
class LRUCache {

    private class Node {

        private int key;
        private int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;

    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        //left = least recently used , right = most recent used
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if (cache.size() > capacity) {
            // remove from the list and delte the LRU from the hashmap
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    // remove node from list
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // insert node at right
    public void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }


}



























