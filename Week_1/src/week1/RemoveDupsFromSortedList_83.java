package week1;

public class RemoveDupsFromSortedList_83 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode slow=head,fast=head.next;
        while(fast!=null){
            while(fast!=null&&slow.val==fast.val)fast=fast.next;
            slow.next=fast;
            slow=fast;
        }
        return head;
    }
}
