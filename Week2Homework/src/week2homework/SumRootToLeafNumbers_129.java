package week2homework;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
    	if(root==null)return 0;
        int[] sum=new int[]{0};
        int pre=0;
        helper(root,pre,sum);
        return sum[0];
    }
    // recursion
    private void helper(TreeNode root,int pre,int[] sum){
    	if(root.left==null&&root.right==null)sum[0]+=10*pre+root.val; // base case: leaf node
    	if(root.left!=null)helper(root.left,10*pre+root.val,sum);	// recursion on left subtree
    	if(root.right!=null)helper(root.right,10*pre+root.val,sum);	// recursion on right subtree
    }
}
