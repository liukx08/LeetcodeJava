package week2homework;

import java.util.Queue;
import java.util.LinkedList;

public class MinimumDepthBT_111 {
	// recursion
    public int minimumDepth(TreeNode root) {
        if(root==null)return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return left==0||right==0?left+right+1:Math.min(left,right)+1;
    }
	// BFS
	public int minDepth(TreeNode root) {
    	if(root==null)return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int min=1,count=1,next=2;
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode tmp=queue.poll();
        	count--;
        	if(tmp.left==null&&tmp.right==null)return min;
        	if(tmp.left!=null){
        		queue.offer(tmp.left);
        	} else next--;
        	if(tmp.right!=null){
        		queue.offer(tmp.right);
        	} else next--;
        	if(count==0){
        		count=next;
        		min++;
        		next=next*2;
        	}
        }
        return min;
    }
}
