package week2homework;

public class CountUnivalueSubtrees_250 {
    public int countUnivalSubtrees(TreeNode root) {
        int[] res=new int[]{0};
        count(root,res);
        return res[0];
    }
    
    private boolean count(TreeNode root,int[] count){
    	if(root==null)return true;			// base case
    	boolean left=count(root.left,count);	// count left, return if left subtree is a univalue subtree
    	boolean right=count(root.right,count);	// count right, return if right subtree is a univalue subtree 
    	if(!left||!right)return false;	// if either subtree is not univalue, neither is the current one 
    	// divide and conquer
    	if(root.left==null&&root.right==null){ // leaves must be univalue subtree 
    		count[0]++;
    		return true;
    	}
    	if(root.left!=null&&root.right==null){	// only has left univalue subtree, judge if current value equals the left value
    		if(root.val==root.left.val){
    			count[0]++;
    			return true;
    		} else return false;
    	}
    	if(root.left==null&&root.right!=null){ // only has right univalue subtree, judge if current value equals the right value
    		if(root.val==root.right.val){
    			count[0]++;
    			return true;
    		} else return false;
    	}
    	if(root.val==root.left.val&&root.val==root.right.val){	// has both subtrees, judge if current value equals both
    		count[0]++;
    		return true;
    	} else return false;
    }
}
