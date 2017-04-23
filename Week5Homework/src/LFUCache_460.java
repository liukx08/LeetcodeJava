import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liukx08 on 4/23/2017.
 *
 *      use doubly linked list to record frequency
 *      each node has a LinkedHashMap containing all entries with the same frequency
 *      use a HashMap to contain key-node entries
 *
 *
 */
public class LFUCache_460 {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;

    private static class Node {
        // record frequency
        public int count;
        // double link
        public Node prev;
        public Node next;
        // store key value entries
        public LinkedHashMap<Integer, Integer> entries;
        public Node(int count) {
            entries = new LinkedHashMap<>();
            this.count = count;
        }
    }

    public LFUCache_460(int capacity) {
        this.capacity = capacity;
        head = new Node(0);
        cache = new HashMap<>();
    }

    public int get(int key) {
        // no key
        if(!cache.containsKey(key)) {
            return -1;
        }
        // update key frequency
        countKey(key);
        return cache.get(key).entries.get(key);
    }

    public void put(int key, int value) {
        // corner case, zero capacity cache
        if(capacity == 0) {
            return;
        }
        // key exists
        if(cache.containsKey(key)) {
            // update value
            cache.get(key).entries.put(key, value);
            // update key frequency
            countKey(key);
            return;
        }
        // key doesn't exist
        // if full, remove least recently used key in least frequently used keys first
        if(cache.size() == capacity) {
            removeOld();
        }
        // add new key
        addNew(key, value);
    }

    private void countKey(int key) {
        // get key node first
        Node curr = cache.get(key);
        // if the node with count + 1 frequency doesn't exist
        if(curr.next == null || curr.next.count != curr.count + 1) {
            Node next = new Node(curr.count + 1);   // create new node with count + 1 frequency
            next.entries.put(key, curr.entries.get(key)); // put key entry into new node
            cache.put(key, next);   // update key node mapping in cache
            // insert new node into list
            next.next = curr.next;
            curr.next = next;
            next.prev = curr;
            if(next.next != null) {
                next.next.prev = next;
            }
        } else {
            // put key value into next node directly
            curr.next.entries.put(key, curr.entries.get(key));
            cache.put(key, curr.next); // update key node mapping in cache
        }
        curr.entries.remove(key); // remove old key value in original frequency node
        // if this node has no entry any more, remove it
        if(curr.entries.size() == 0) {
            removeNode(curr);
        }
    }

    private void removeOld() {
        // locate the first entered key through the linkedHashMap
        int key = head.next.entries.keySet().iterator().next();
        cache.remove(key);
        head.next.entries.remove(key);
        if(head.next.entries.size() == 0) {
            removeNode(head.next);
        }
    }

    private void addNew(int key, int value) {
        if(head.next == null || head.next.count != 1) {
            Node newNode = new Node(1);
            newNode.entries.put(key, value);
            cache.put(key, newNode);
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
            if(newNode.next != null) {
                newNode.next.prev = newNode;
            }
        } else {
            head.next.entries.put(key, value);
            cache.put(key, head.next);
        }
    }

    private void removeNode(Node curr) {
        curr.prev.next = curr.next;
        if(curr.next != null) {
            curr.next.prev = curr.prev;
        }
    }

    public static void main(String[] args) {
        LFUCache_460 test = new LFUCache_460(0);
        test.put(0, 0);
        test.get(0);
    }
}
