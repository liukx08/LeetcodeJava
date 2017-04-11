/**
 * Created by liukx08 on 4/11/2017.
 */
public class MergeKSortedLists_23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // divide and conquer, merge two by two
    public ListNode mergeKLists(ListNode[] lists){
        return partition(lists,0,lists.length-1);
    }

    private ListNode partition(ListNode[] lists,int start,int end){
        if(start>end)return null;
        if(start==end)return lists[start];
        int mid=(start+end)>>>1;
        ListNode list1=partition(lists,start,mid);
        ListNode list2=partition(lists,mid+1,end);
        return merge(list1,list2);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        if(l1==null||l2==null)return l1==null?l2:l1;
        ListNode curr;
        if(l1.val<l2.val){
            curr=l1;
            curr.next=merge(l1.next,l2);
        } else {
            curr=l2;
            curr.next=merge(l1,l2.next);
        }
        return curr;
    }
}
