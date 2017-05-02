/**
 * Created by liukx08 on 5/1/2017.
 */
public class ReverseKGroup_25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        ListNode curr = head;
        // if length < k, return
        for(int i = 0; i < k - 1; i++) {
            if(curr.next == null) {
                return head;
            } else {
                curr = curr.next;
            }
        }
        // recursion on the tail list from k + 1 th node
        ListNode newHead = reverseKGroup(curr.next, k);
        curr = head;
        // reverse the first k nodes
        for(int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = next;
        }
        return newHead;
    }
}
