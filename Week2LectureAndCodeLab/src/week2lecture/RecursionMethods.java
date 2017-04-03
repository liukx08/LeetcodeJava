package week2lecture;

import java.util.List;
import java.util.ArrayList;

public class RecursionMethods {
	public ListNode reverseList(ListNode head){
		if(head==null||head.next==null)return head; //base case
		ListNode newHead=reverseList(head.next);	// recursion 
		head.next.next=head;						// combine
		head.next=null;
		return newHead;
	}
	
	public TreeNode searchBST(TreeNode root,int val){  
		if(root==null||root.val==val)return root;	//base case
		if(val<root.val)return searchBST(root.left,val);  // recursion
		else return searchBST(root.right,val);	//recursion
	}											//no combine
	
	public TreeNode insertBST(TreeNode root,int val){
		if(root==null)return new TreeNode(val);		//base case
		if(root.val>val){
			root.left=insertBST(root.left,val);		//recursion
		}else if(root.val<val){
			root.right=insertBST(root.right,val);	//recursion
		}
		return root;								// no combine
	}
	
	public boolean isValidBST(TreeNode root){
		return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}
	
	private boolean isValidBST(TreeNode root,int max,int min){  // top-down
		if(root==null)return true;		// base case
		if(root.val>=max||root.val<=min)return false;  // "combine", process current level
		return isValidBST(root.left,root.val,min)&&isValidBST(root.right,max,root.val);  // recursion
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q){ // bottom-up
		if(root==null)return null;		// base case
		if(root==p||root==q)return root;	// base case
		TreeNode left=lowestCommonAncestor(root.left,p,q);  // recursion
		TreeNode right=lowestCommonAncestor(root.right,p,q);	// recursion
		if(left==null||right==null)return left==null?right:left;	// combine
		else return root;											// combine
	}
	
	public TreeNode lCAK(TreeNode root,TreeNode[] p){
		if(root==null)return null;	// base case
		for(TreeNode tmp:p){				
			if(root==tmp)return root;
		}								// base case
		TreeNode left=lCAK(root.left,p);  // recursion
		TreeNode right=lCAK(root.right,p);	// recursion
		if(left==null||right==null)return left==null?right:left;	// combine
		else return root;											// combine
	}
	
	public TreeNode lCAK2(TreeNode root,TreeNode[] p){		//if p is not guaranteed in the tree
		int[] count=new int[]{0};
		TreeNode res=helper(root,p,count);
		return count[0]==p.length?res:null;
	}
	
	private TreeNode helper(TreeNode root,TreeNode[] p,int[] count){
		if(root==null)return null;	// base case
		TreeNode left=helper(root.left,p,count);  // recursion
		TreeNode right=helper(root.right,p,count);	// recursion
		for(TreeNode tmp:p){				
			if(root==tmp){
				count[0]++;
				return root;
			}
		}								// base case 
		if(left==null||right==null)return left==null?right:left;	// combine
		else return root;			
	}
	
	public List<Integer> traversal(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		preorderTraversal(root,res);
		return res;
	}
	
	public void preorderTraversal(TreeNode root,List<Integer> list){
		if(root==null)return;		// base case
		list.add(root.val);			// "combine", process current level
		preorderTraversal(root.left,list);		// 	recursion left subtree
		preorderTraversal(root.right,list);		//	recursion right subtree
	}
	
	public void inorderTraversal(TreeNode root,List<Integer> list){
		if(root==null)return;		// base case
		inorderTraversal(root.left,list);	// 	recursion left subtree
		list.add(root.val);					// "combine", process current level
		inorderTraversal(root.right,list);	//	recursion right subtree
	}
	
	public void postorderTraversal(TreeNode root,List<Integer> list){
		if(root==null)return;		// base case
		postorderTraversal(root.left,list);	// 	recursion left subtree
		postorderTraversal(root.right,list);	//	recursion right subtree
		list.add(root.val);					// "combine", process current level
	}
	
	public TreeNode inorderSuccessor(TreeNode root,TreeNode p){
		if(root==null||p==null)return null; // base case			
		if(root.val>p.val){
			TreeNode left=inorderSuccessor(root.left,p);	// if p val < root val => recursion on left subtree
			return left==null?root:left;		// recursion may return null (when root is the successor)
		}
		else return inorderSuccessor(root.right,p);		// if p val >= root val => recursion on right subtree
	}
	
	public int kthSmallest(TreeNode root, int k){
		int[] count=new int[]{k};
		int[] result=new int[]{-1};
		inorderTraversal(root,count,result);	// use a inorderTraversal to find kth smallest
		return result[0];
	}
	
	private void inorderTraversal(TreeNode root,int[] count,int[] result){
		if(root==null)return;		// base case
		inorderTraversal(root.left,count,result);	// recursion on left subtree
		count[0]--;					// process current level
		if(count[0]==0){
			result[0]=root.val;
			return;
		}
		inorderTraversal(root.right,count,result);  // recursion on right subtree
	}  // to find kth largest, code traversal on right subtree first
	
	public boolean isSymmetric(TreeNode root){
		if(root==null)return true;
		return isSymmetric(root.left,root.right);
	}
	
	private boolean isSymmetric(TreeNode left,TreeNode right){
		if(left==null||right==null)return left==null&&right==null?true:false; // base case
		if(left.val==right.val)return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);  // process current level and recursion on next level
		return false;
	}
	
	public TreeNode invertTree(TreeNode root){
		if(root==null)return root;
		TreeNode tmp=root.left;
		root.left=root.right;
		root.right=tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
