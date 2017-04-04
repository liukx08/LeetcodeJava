package week2homework;

public class LongestConsecutiveSequence_298 {	// DFS
    public int longestConsecutive(TreeNode root) {
        if(root==null)return 0;
        return longestConsecutive(root,0,root.val-1);
    }
    
    private int longestConsecutive(TreeNode root,int count,int last){ // count is the consecutive sequence length to the parent node
    	if(root==null)return count;			// base case, leaf node
    	if(root.val==last+1)count++;	// if consecutive, count+1
    	else count=1;	// if not consecutive, reset
    	int left=longestConsecutive(root.left,count,root.val); // recursion on left subtree
    	int right=longestConsecutive(root.right,count,root.val);	// recursion on right subtree
    	return Math.max(Math.max(left, right),count);	// compare to get the longest one
    }
}
