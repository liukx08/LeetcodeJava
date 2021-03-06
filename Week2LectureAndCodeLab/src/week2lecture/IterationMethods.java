package week2lecture;

import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class IterationMethods {
	public ListNode reverseList(ListNode head){
		if(head==null)return head; 
		ListNode newhead=null;
		ListNode next;
		while(head!=null){
			next=head.next;
			head.next=newhead;
			newhead=head;
			head=next;
		}
		return newhead;
	}
	
	public TreeNode searchBST(TreeNode root,int val){
		TreeNode curr=root;
		while(curr!=null){
			if(curr.val>val)curr=curr.left;
			else if(curr.val<val)curr=curr.right;
			else return curr;
		}
		return curr;
	}
	
	public TreeNode insertBST(TreeNode root,int val){
		if(root==null)return new TreeNode(val);
		TreeNode curr=root,parent=curr;
		while(curr!=null){
			parent=curr;
			if(curr.val>val)curr=curr.left;
			else if(curr.val<val)curr=curr.right;
			else return root;
		}
		if(parent.val>val)parent.left=new TreeNode(val);
		else parent.right=new TreeNode(val);
		return root;
	}
	
	public boolean isValidBST(TreeNode root){		//	inorderTraversal iteration
		Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
		if(root==null)return true;
		TreeNode curr=root,prev=null;
		while(!stack.isEmpty()||curr!=null){
			if(curr!=null){
				stack.offerFirst(curr);
				curr=curr.left;
			}
			else {
				curr=stack.pollFirst();
				if(prev!=null&&prev.val>curr.val)return false;
				prev=curr;
				curr=curr.right;
			}
		}
		return true;
	}
	
	// How to locate lowest common ancestor iteratively?
	
	public List<Integer> preorderTraversal(TreeNode root){	
		List<Integer> res=new ArrayList<Integer>();
		Deque<TreeNode> stack=new ArrayDeque<TreeNode>();	// use stack
		if(root==null)return res;
		stack.offerFirst(root);
		TreeNode curr;
		while(!stack.isEmpty()){
			curr=stack.pollFirst();			// process current node first (pre-order)
			res.add(curr.val);
			if(curr.right!=null)stack.offerFirst(curr.right);	// push right node into stack
			if(curr.left!=null)stack.offerFirst(curr.left);		// push left node into stack
		}
		return res;
	}
	
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		Deque<TreeNode> stack=new ArrayDeque<TreeNode>();	// use stack
		if(root==null)return res;
		TreeNode curr=root;
		while(!stack.isEmpty()||curr!=null){
			if(curr!=null){
				stack.offerFirst(curr);			// push current node into stack
				curr=curr.left;
			} else {
				curr=stack.pollFirst();		// process the most left node first
				res.add(curr.val);
				if(curr.right!=null)stack.offerFirst(curr.right);	// push right node into stack
			}
		}
		return res;
	}
	
	public List<Integer> postorderTraversal(TreeNode root){  	//pre-order: curr, left, right; reverse post-order: curr, right, left
		LinkedList<Integer> res=new LinkedList<Integer>();	 // use LinkedList to use offerFirst
		Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
		if(root==null)return res;
		stack.offerFirst(root);
		TreeNode curr;
		while(!stack.isEmpty()){
			curr=stack.pollFirst();			// process current node first (pre-order)
			res.offerFirst(curr.val);		// add current node in front of the list
			if(curr.left!=null)stack.offerFirst(curr.left);	// push left node into stack
			if(curr.right!=null)stack.offerFirst(curr.right);		// push right node into stack
		}
		return res;
	}
	
	public TreeNode inorderSuccessor(TreeNode root,TreeNode p){
		TreeNode successor=null;
		if(p==null)return successor;
		TreeNode curr=root;
		while(curr!=null){
			if(curr.val>p.val){	// if target val < current val => current is successor or successor is in the left of current node
				successor=curr;
				curr=curr.left;
			} else {			// if target val >= current val => successor must be in the right of current node
				curr=curr.right;
			}
		}
		return successor;
	}
	
	public int kthSmallest(TreeNode root, int k){
		if(root==null)return -1;
		Deque<TreeNode> stack=new ArrayDeque<TreeNode>();	// in-order traversal
		TreeNode curr=root;
		while(!stack.isEmpty()||curr!=null){
			if(curr!=null){
				stack.offerFirst(curr);
				curr=curr.left;
			}
			else {
				TreeNode tmp=stack.pollFirst();
				k--;							// count
				if(k==0)return tmp.val;
				if(tmp.right!=null)stack.offerFirst(tmp.right);
			}
		}
		return -1;
	}
	
	public boolean isSymmetric(TreeNode root){		// BFS traversal
		if(root==null)return true;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()){
			TreeNode left=queue.poll();
			TreeNode right=queue.poll();
			if(left==null&&right==null)continue;
			if(left==null||right==null)return false;
			if(left.val!=right.val)return false;
			queue.offer(left.left);
			queue.offer(right.right);
			queue.offer(left.right);
			queue.offer(right.left);
		}
		return true;
	}
}
