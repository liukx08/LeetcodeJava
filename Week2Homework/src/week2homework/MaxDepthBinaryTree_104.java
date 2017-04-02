package week2homework;

public class MaxDepthBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;			// base case
        int left=maxDepth(root.left);	// recursion on left subtree
        int right=maxDepth(root.right);	// recursion on right subtree
        return (left>right?left:right)+1;	// combine at current level
    }
}
