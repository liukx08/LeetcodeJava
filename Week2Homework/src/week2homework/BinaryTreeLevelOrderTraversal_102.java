package week2homework;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> level=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();	// Use BFS
        if(root==null)return res;
        queue.offer(root);
        int count=1,nextsize=2*count;		// Use a counter to track the number of elements in each level
        while(!queue.isEmpty()){
        	TreeNode tmp=queue.poll();
        	level.add(tmp.val);
        	count--;
        	if(tmp.left!=null){
        		queue.offer(tmp.left);
        	} else {
        		nextsize--;
        	}
        	if(tmp.right!=null){
        		queue.offer(tmp.right);
        	} else {
        		nextsize--;
        	}
        	if(count==0){
        		res.add(level);
        		level=new ArrayList<Integer>();
        		count=nextsize;
        		nextsize=2*count;
        	}
        }
        return res;
    }
}
