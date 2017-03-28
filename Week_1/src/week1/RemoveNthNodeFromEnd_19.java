package week1;

public class RemoveNthNodeFromEnd_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end=head,parent=head;
        for(int i=0;i<n;i++)end=end.next;
        if(end==null){
            head=head.next;
            return head;
        }
        while(end.next!=null){
            end=end.next;
            parent=parent.next;
        }
        parent.next=parent.next.next;
        return head;
    }
}
