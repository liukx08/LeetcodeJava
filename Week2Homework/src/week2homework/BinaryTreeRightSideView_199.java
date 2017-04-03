package week2homework;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {  // Use BFS and count to locate the most right element at each level
        List<Integer> res=new ArrayList<Integer>();
        Deque<TreeNode> queue=new ArrayDeque<TreeNode>();
        if(root==null)return res;
        queue.offer(root);
        res.add(root.val);
        int count=1,next=2*count;
        while(!queue.isEmpty()){
        	TreeNode tmp=queue.poll();
        	count--;
        	if(tmp.right!=null){
        		queue.offer(tmp.right);
        	} else {
        		next--;
        	}
        	if(tmp.left!=null){
        		queue.offer(tmp.left);
        	} else {
        		next--;
        	}
        	if(count==0){
        	    if(!queue.isEmpty())res.add(queue.peek().val);
        		count=next;
        		next=next*2;
        	}
        }
        return res;
    }
}
