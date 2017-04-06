package leetcode;

import java.util.Map;
import java.util.HashMap;

public class HouseRobberIII_337 {
	// simple recursion method: many repeated calculation, extremely slow
    public int rob(TreeNode root) {
        if(root==null)return 0;
        int val=0;
        if(root.left!=null)val+=rob(root.left.left)+rob(root.left.right);
        if(root.right!=null)val+=rob(root.right.left)+rob(root.right.right);
        return Math.max(val+root.val, rob(root.left)+rob(root.right));
    }
    // DP recursion
    public int dprob(TreeNode root) {
    	return dprob(root,new HashMap<>());
    }
    private int dprob(TreeNode root, Map<TreeNode,Integer> map){
    	if(root==null)return 0;
    	if(map.containsKey(root))return map.get(root);
    	int val=0;
        if(root.left!=null)val+=dprob(root.left.left,map)+dprob(root.left.right,map);
        if(root.right!=null)val+=dprob(root.right.left,map)+dprob(root.right.right,map);
        val=Math.max(val+root.val, dprob(root.left,map)+dprob(root.right,map));
        map.put(root, val);
        return val;
    }
    // optimized recursion
    public int orrob(TreeNode root) {
    	int[] res=oprob(root);
    	return Math.max(res[0], res[1]);
    }
    
    private int[] oprob(TreeNode root){
    	int[] res=new int[]{0,0};
    	if(root==null)return res;
    	int[] left=oprob(root.left);
    	int[] right=oprob(root.right);
    	res[0]=Math.max(left[0], left[1])+Math.max(right[0], right[1]);
    	res[1]=root.val+left[0]+right[0];
    	return res;
    }
}
