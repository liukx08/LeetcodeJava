package leetcode;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class BTLevelOrderTraversalII_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        depth(root,res,1);
        return res;
    }
    
    private void depth(TreeNode root,LinkedList<List<Integer>> res,int level){
    	if(root==null)return;
    	if(res.size()<level)res.addFirst(new ArrayList<Integer>());
    	res.get(res.size()-level).add(root.val);
    	depth(root.left,res,level+1);
    	depth(root.right,res,level+1);
    }
}
