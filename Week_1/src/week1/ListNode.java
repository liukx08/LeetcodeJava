package week1;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x){ val = x;}
	
	public void printList(ListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println("");
	}
	
	public ListNode buildList(int[] nums){		// create a linkedlist for quick test
		ListNode head=null,curr=head;
		if(nums.length>0){head=new ListNode(nums[0]);curr=head;}
		for(int i=1;i<nums.length;i++){	
			curr.next=new ListNode(nums[i]);
			curr=curr.next;
		}
		return head;
	}
}
