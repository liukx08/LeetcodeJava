package week2homework;

public class SumLeftLeaves_404 {
	public int sumOfLeft(TreeNode root) {
		if(root==null)return 0;
		int res=0;
		if(root.left!=null){
			if(root.left.left==null&&root.left.right==null)res+=root.left.val;
			else res+=sumOfLeft(root.left);
		}
		res+=sumOfLeft(root.right);
		return res;
	}
	
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        int left=sumOfLeftLeaves(root.left);
        int right=sumOfLeftLeaves(root.right);
        if(root.left==null)return right;
        if(root.left.left==null&&root.left.right==null)return root.left.val+right;
        return left+right;
    }
}
