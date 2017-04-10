/**
 * Created by liukx08 on 4/10/2017.
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // use list version merge sort
    public ListNode sortList(ListNode head){
        if(head==null||head.next==null)return head; // base case
        ListNode fast=head.next,slow=head;  // double pointer, find mid
        int length=2;  // count length
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            length+=2;
        }
        if(fast==null)length--;
        fast=slow.next;     // disconnect to two lists
        slow.next=null;
        head=sortList(head);    // sort the first list
        fast=sortList(fast);    // sort the second list
        head=merge(head,fast,length);   // merge sorted list
        return head;
    }

    private ListNode merge(ListNode h1, ListNode h2, int length){
        ListNode fakeHead=new ListNode(0);
        ListNode curr=fakeHead;
        for(int i=0;i<length;i++){
            if(h1==null){
                curr.next=h2;
                curr=curr.next;
                h2=h2.next;
            } else if(h2==null){
                curr.next=h1;
                curr=curr.next;
                h1=h1.next;
            } else {
                curr.next=h1.val<=h2.val?h1:h2;
                curr=curr.next;
                if(curr==h1)h1=h1.next;
                else h2=h2.next;
            }
        }
        return fakeHead.next;
    }
}
