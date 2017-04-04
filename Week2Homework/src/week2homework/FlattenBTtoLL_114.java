package week2homework;

public class FlattenBTtoLL_114 {
	// intuitive recursion
	public void flatten2(TreeNode root) {
        if(root==null)return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        flatten2(left);
        flatten2(right);
        root.left=null;
        root.right=left;
        TreeNode curr=root;
        while(curr.right!=null)curr=curr.right;
        curr.right=right;
    }
	
	// ugly method
	public void flatten(TreeNode root) {
        if(root==null)return;
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
    	if(root.left!=null&&root.right!=null){
    		tail(root.left).right=helper(root.right);
    		root.right=helper(root.left);
    		root.left=null;
    		return root;
    	} 
    	if(root.right!=null){
    		root.right=helper(root.right);
    		return root;
    	}
    	if(root.left!=null){
    	    root.right=helper(root.left);
    	    root.left=null;
    	}
    	return root;
    }
    
    private TreeNode tail(TreeNode root){
    	if(root.left==null&&root.right==null)return root;
    	if(root.right!=null)return tail(root.right);
    	return tail(root.left);
    }
}
