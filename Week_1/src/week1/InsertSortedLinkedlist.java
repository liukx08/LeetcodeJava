package week1;

public class InsertSortedLinkedlist {
	public ListNode insert(ListNode head, int target){
		if(head==null)return new ListNode(target);
		ListNode curr=head,prev=head;
		if(head.val>target){
			head=new ListNode(target);
			head.next=curr;
			return head;
		}
		while(curr!=null&&curr.val<target){
			prev=curr;
			curr=curr.next;
		}
		if(curr!=null&&curr.val==target);
		else {
			prev.next=new ListNode(target);
			prev.next.next=curr;
		}
		return head;
	}
}
