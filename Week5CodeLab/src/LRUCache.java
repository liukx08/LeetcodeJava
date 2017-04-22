import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukx08 on 4/22/2017.
 */
public class LRUCache {
    // doubly linked node to achieve O(1) insert and remove
    private static class Node {
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    // use map to achieve O(1) lookup
    Map<Integer, Node> map;

    Node head;

    Node tail;

    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        // use dummy head and tail nodes to simplify code
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        // no key
        if(!map.containsKey(key)) {
            return -1;
        }
        // get node
        Node curr = map.get(key);
        // move this node in front (most recently used)
        // connect prev and next first
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // insert curr after head
        curr.next = head.next;
        curr.prev = head;
        // link head and original head.next to curr
        curr.next.prev = curr;
        head.next = curr;
        return curr.val;
    }

    public void put(int key, int value) {
        // key exists, update value
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
            curr.next = head.next;
            curr.prev = head;
            curr.next.prev = curr;
            head.next = curr;
            return;
        }
        // full, remove node at tail (LRU)
        if(map.size() == capacity) {
            map.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
        // add new node
        Node curr = new Node(key, value);
        map.put(key, curr);
        curr.next = head.next;
        curr.prev = head;
        curr.next.prev = curr;
        head.next = curr;
        return;
    }
}
