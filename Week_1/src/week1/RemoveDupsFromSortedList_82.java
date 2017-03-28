package week1;

public class RemoveDupsFromSortedList_82 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode curr=head,next,prev=head;
        while(curr!=null){
            next=curr.next;
            if(next==null)return head;
            else if(next.val!=curr.val){
                prev=curr;
            }
            else {
                while(next!=null&&next.val==curr.val)next=next.next;
                if(head==curr){
                    head=next;
                }
                else {
                    prev.next=next;
                }
            }
            curr=next;
        }
        return head;
    }
}
