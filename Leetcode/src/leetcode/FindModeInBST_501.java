package leetcode;

public class FindModeInBST_501 {
	// Real O(1) space, use morris traversal
    public int[] findMode(TreeNode root) {
        if(root==null)return new int[0];
        morris(root);			// first traversal, count how many modes there is
        res=new int[nmode];		// initialize result array
        count=0;
        nmode=0;
        morris(root);	// second traversal, record each mode
        return res;
    }
    
    private int currval;	// track the value of each node 
    private int count=0;	// count the frequency of current node
    private int fmode=0;	// track the frequency of mode
    private int nmode=0;	// track number of modes
    private int[] res;
    
    private void countMode(TreeNode root){
    	if(root.val!=currval){		
    		count=0;		// if new value comes out, recount from 0
    		currval=root.val;	// and update current value
    	}
    	count++;			// count current value
    	if(count>fmode){	// found mode
    		fmode=count;	// update mode, discard the old one
    		nmode=1;		// reset number of modes to 1 
    	} else if(count==fmode){	// found another mode
    		if(res!=null)res[nmode]=currval;	// if second traversal, record the mode
    		nmode++;	// count mode
    	}
    }
    
    private void morris(TreeNode root){
    	if(root==null)return;
    	TreeNode curr=root;
    	while(curr!=null){
    		if(curr.left==null){
    			countMode(curr);
    			curr=curr.right;
    		} else {
    			TreeNode parent=curr.left;
    			while(parent.right!=null&&parent.right!=curr)parent=parent.right;
    			if(parent.right==null){
    				parent.right=curr;
    				curr=curr.left;
    			} else {
    				parent.right=null;
    				countMode(curr);
    				curr=curr.right;
    			}
    		}
    	}
    }
}
