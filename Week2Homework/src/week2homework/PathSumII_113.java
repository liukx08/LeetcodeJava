package week2homework;

import java.util.List;
import java.util.ArrayList;

public class PathSumII_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> onepath=new ArrayList<Integer>();
        path(root,sum,res,onepath);
        return res;
    }
	
	private void path(TreeNode root, int sum, List<List<Integer>> res, List<Integer> onepath){
		if(root==null)return;	// base case
		onepath.add(root.val);	// add current level value into onepath
		if(root.left==null&&root.right==null&&root.val==sum)res.add(new ArrayList<Integer>(onepath)); // if at onepath end, judge if the sum matches
		path(root.left,sum-root.val,res,onepath);	// recursion on left path
		path(root.right,sum-root.val,res,onepath);	// recursion on right path
		onepath.remove(onepath.size()-1);	// remove the last element before backtracking
	}
}
