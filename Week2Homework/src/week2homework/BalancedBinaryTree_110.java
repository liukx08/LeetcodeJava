package week2homework;

public class BalancedBinaryTree_110 {
	public boolean isBalanced(TreeNode root) { //O(n)
		if(root==null) return true;
		return height(root)==-1?false:true;
	}
	
	private int height(TreeNode root) {		// if not balance return -1, else return depth
		if(root==null)return 0;
        int l=height(root.left);
        if(l==-1)return -1;
        int r=height(root.right);
        if(r==-1)return -1;
        if(Math.abs(l-r)>1)return -1;
        return (l>r?l:r)+1;
	}
	
    public boolean isBalance(TreeNode root) {	// T(n)=2T(n/2)+O(n)	O(nlogn)  too slow.
        if(root==null)return true;	// base case
        boolean left=isBalance(root.left);		// recursion on left subtree
        boolean right=isBalance(root.right);	// recursion on right subtree
        return Math.abs(depth(root.left)-depth(root.right))<=1&&left&&right;	// combine: does left depth equal right depth? is left balanced? is right balanced?
    }
    
    private int depth(TreeNode root) {	// T(n)=2T(n/2)+O(1) => O(n)
        if(root==null)return 0;
        int l=depth(root.left);
        int r=depth(root.right);
        return (l>r?l:r)+1;
    }
}
