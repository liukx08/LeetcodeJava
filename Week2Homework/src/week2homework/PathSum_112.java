package week2homework;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum_112 {
	public boolean hasPathSumRecursion(TreeNode root, int sum){
		if(root==null)return false;
		if(root.left==null&&root.right==null&&root.val==sum)return true;	// base case
		return hasPathSumRecursion(root.left,sum-root.val)||hasPathSumRecursion(root.right,sum-root.val); // recursion
	}
	
    public boolean hasPathSum(TreeNode root, int sum) { // BFS, use a queue to store current sum
        if(root==null)return false;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<Integer> count=new LinkedList<Integer>();
        queue.offer(root);
        count.offer(root.val);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            int currsum=count.poll();
            if(curr.left==null&&curr.right==null&&currsum==sum)return true;
            if(curr.left!=null){
                queue.offer(curr.left);
                count.offer(currsum+curr.left.val);
            }
            if(curr.right!=null){
                queue.offer(curr.right);
                count.offer(currsum+curr.right.val);
            }
        }
        return false;
    }
}
