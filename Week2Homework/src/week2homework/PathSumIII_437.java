package week2homework;

public class PathSumIII_437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)return 0;
        return onepath(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    
    private int onepath(TreeNode root,int sum) {
    	int res=0;
    	if(root==null)return res;
    	if(root.val==sum)res++;
    	res+=onepath(root.left,sum-root.val);
    	res+=onepath(root.right,sum-root.val);
    	return res;
    }
}
