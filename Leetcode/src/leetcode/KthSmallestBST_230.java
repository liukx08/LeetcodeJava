package leetcode;

public class KthSmallestBST_230 {
    public int kthSmallest(TreeNode root, int k) {
    	int[] count=new int[]{k};
    	int[] res=new int[1];
    	helper(root,count,res);
    	return res[0];
    }
    
    private void helper(TreeNode root,int[] count,int[] res){
    	if(root.left!=null)helper(root.left,count,res);
    	count[0]--;
    	if(count[0]==0){
    		res[0]=root.val;
    		return;
    	}
    	if(root.right!=null)helper(root.right,count,res);
    }
}
