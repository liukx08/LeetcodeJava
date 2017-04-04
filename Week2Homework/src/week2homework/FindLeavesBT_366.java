package week2homework;

import java.util.List;
import java.util.ArrayList;

public class FindLeavesBT_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        height(root,res);
        return res;
    }
    // bottom-up, leaves are the first level (height=1)
    private int height(TreeNode root,List<List<Integer>> list){
    	if(root==null)return 0;	// base case
    	int left=height(root.left,list);	// recursion on left subtree
    	int right=height(root.right,list);	// recursion on right subtree
    	int h=Math.max(left, right)+1;		// calculate the height of current node
    	if(list.size()<h)list.add(new ArrayList<Integer>());	
    	list.get(h-1).add(root.val);	// add the current node to its corresponding level
    	return h;
    }
}
