package week1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
	public ListNode mergeLists(ListNode[] lists){	//this method uses min heap
		if(lists.length==0)return null;
		PriorityQueue<ListNode> heap=new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
			@Override
			public int compare(ListNode a,ListNode b){
                if (a.val>b.val){
                    return 1;
                }else if (a.val==b.val){
                    return 0;
                }else{ 
                    return -1;
                }
			}
		});
		ListNode fakehead=new ListNode(0);
		ListNode tail=fakehead;
		for(int i=0;i<lists.length;i++){
			if(lists[i]!=null)heap.offer(lists[i]);
		}
		while(!heap.isEmpty()){
			tail.next=heap.poll();
			tail=tail.next;
			if(tail.next!=null)heap.offer(tail.next);
		}
		return fakehead.next;
	}
	
    public ListNode mergeKLists(ListNode[] lists) {   // this method exceeds time limit, should use min heap
        ListNode fakehead=new ListNode(0);
        ListNode curr=fakehead;
        int K=lists.length;
        for(int i=0,j=0;i<lists.length;i++){
            if(lists[i]!=null){
                lists[j]=lists[i];
                j++;
            }
            else K--;
        }
        if(K==0)return null;
        lists=quicksort(lists,0,K-1);
        int low,high,insert;
        while(K>1){
            curr.next=lists[0];
            if(lists[0].next==null){
                K--;
                for(int i=0;i<K;i++)lists[i]=lists[i+1];
            }
            else{
                low=1;
                high=K-1;
                insert=(low+high)/2;
                while(low<=high){
                    insert=(low+high)/2;
                    if(lists[insert].val<lists[0].next.val)low=insert+1;
                    else high=insert-1;
                }
                ListNode tmp=lists[0].next;
                for(int i=0;i<high;i++)lists[i]=lists[i+1];
                lists[high]=tmp;
            }
            curr=curr.next;
        }
        curr.next=lists[0];
        return fakehead.next;
    }
    
    private ListNode[] quicksort(ListNode[] nums,int low,int high){
        if(low>=high)return nums;
        int pivot=nums[high].val;
        int pos=low;
        for(int i=low;i<high;i++){
            if(nums[i].val<=pivot){
                ListNode tmp=nums[i];
                nums[i]=nums[pos];
                nums[pos++]=tmp;
            }
        }
        ListNode tmp=nums[high];
        nums[high]=nums[pos];
        nums[pos]=tmp;
        quicksort(nums,low,pos-1);
        quicksort(nums,pos+1,high);
        return nums;
    }
}
