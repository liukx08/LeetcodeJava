package week1;

public class FindMiddle {
	public ListNode find(ListNode head){
		if(head==null)return head;
		ListNode middle=head;
//		head=head.next;   // uncomment this line to return n/2 th Node for even number of elements
		while(head!=null){
			head=head.next;
			if(head!=null){
				head=head.next;
				middle=middle.next;
			}
		}
		return middle;
	}
}
