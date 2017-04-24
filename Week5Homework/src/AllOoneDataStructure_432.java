import java.util.*;

/**
 * Created by liukx08 on 4/24/2017.
 *
 *      This problem is similar to LFUCache.
 *      1. The value works like frequency in LFUCache.
 *      2. When getMax/MinKey, any key is OK. Thus LinkedHashMap is not necessary;
 *      LinkedHashSet (ensure iterator() in O(1)) is enough.
 *      3. Need a tail Node to get the max value in O(1).
 *
 */
public class AllOoneDataStructure_432 {
    private Map<String, Node> cache;
    private Node head;
    private Node tail;

    private static class Node {
        // record value
        public int val;
        // double link
        public Node prev;
        public Node next;
        // store keys
        public Set<String> keys;
        public Node(int val) {
            keys = new LinkedHashSet<>();
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public AllOoneDataStructure_432() {
        cache = new HashMap<>();
        // dummy head and tail node
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(cache.containsKey(key)) {
            Node curr = cache.get(key);
            // if val + 1 node doesn't exist, create one
            if(curr.next.val != curr.val + 1) {
                Node next = new Node(curr.val + 1);
                next.next = curr.next;
                next.prev = curr;
                curr.next.prev = next;
                curr.next = next;
            }
            // add key
            curr.next.keys.add(key);
            cache.put(key, curr.next);
            // remove old key
            curr.keys.remove(key);
            // remove empty node
            if(curr.keys.size() == 0) {
                curr.next.prev = curr.prev;
                curr.prev.next = curr.next;
            }
            return;
        }
        if(head.next.val != 1) {
            Node first = new Node(1);
            first.next = head.next;
            first.prev = head;
            head.next.prev = first;
            head.next = first;
        }
        head.next.keys.add(key);
        cache.put(key, head.next);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!cache.containsKey(key)) {
            return;
        }
        Node curr = cache.get(key);
        if(curr.val == 1) {
            curr.keys.remove(key);
            cache.remove(key);
            if(curr.keys.size() == 0) {
                head.next = curr.next;
                curr.next.prev = head;
            }
            return;
        }
        if(curr.prev.val != curr.val - 1) {
            Node prev = new Node(curr.val - 1);
            prev.next = curr;
            prev.prev = curr.prev;
            curr.prev.next = prev;
            curr.prev = prev;
        }
        curr.prev.keys.add(key);
        cache.put(key, curr.prev);
        curr.keys.remove(key);
        if(curr.keys.size() == 0) {
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(cache.size() == 0) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(cache.size() == 0) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}
