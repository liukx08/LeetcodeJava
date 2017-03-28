package week1;

public class Test {
	public static void testInsertSortedLinkedlist(){
		InsertSortedLinkedlist test=new InsertSortedLinkedlist();
		ListNode list=null;
		list=test.insert(list, 3);
		list.printList(list);
		list=test.insert(list, 3);
		list.printList(list);
		list=test.insert(list, 1);
		list.printList(list);
		list=test.insert(list, 5);
		list.printList(list);
		list=test.insert(list, 4);
		list.printList(list);
	}
	
	public static void testFindMiddle(){
		FindMiddle test=new FindMiddle();
		ListNode list=new ListNode(0);		// build an instance for using buildList method
		list=list.buildList(new int[]{1,2,3,4,5}); 
		ListNode middle=test.find(list);
		middle.printList(middle);
	}
	
	public static void testMerge(){
		MergeKSortedLists_23 test=new MergeKSortedLists_23();
		ListNode list=new ListNode(0);
		list=list.buildList(new int[]{0,1,2});
		ListNode[] lists=new ListNode[8];
		lists[0]=list;
//		lists[1]=null;
		list=list.buildList(new int[]{-10,-8,-5,-4});
		lists[1]=list;
		lists[2]=null;
		lists[3]=null;
		list=list.buildList(new int[]{-3});
		lists[4]=list;
		list=list.buildList(new int[]{-10,-9,-6,-4,-3,-2,-2,-1,2});
		lists[5]=list;
		list=list.buildList(new int[]{-9,-9,-2,-1,0,1});
		lists[6]=list;
		list=list.buildList(new int[]{-9,-4,-3,-2,2,2,3,3,4});
		lists[7]=list;
//		lists[0].printList(lists[0]);
//		lists[1].printList(lists[1]);
//		lists[2].printList(lists[2]);
		ListNode result=test.mergeKLists(lists);
		result.printList(result);
	}
}
