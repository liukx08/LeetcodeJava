package leetcode;

public class BTUpsideDown_156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null||root.left==null)return root;
        TreeNode tmp=upsideDownBinaryTree(root.left);
        root.left.left=root.right;
        root.left.right=root;
        root.left=null;
        root.right=null;
        return tmp;
    }
}
