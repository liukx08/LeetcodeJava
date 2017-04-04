package week2homework;

import java.util.ArrayList;
import java.util.List;

public class ClosestBSTValueII_272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res=new ArrayList<Integer>();
        double difference=Math.abs(target-root.val);  // find the closest value first
        TreeNode curr=root,closest=root;
        while(curr!=null){
            if(Math.abs(target-curr.val)<difference){
                difference=Math.abs(target-curr.val);
                closest=curr;
            }
            if(target<curr.val)curr=curr.left;
            else curr=curr.right;
        }
        res.add(closest.val);
        TreeNode pre=getPredecessor(root,closest.val);	// start from successor and predecessor of the closest value
        TreeNode suc=getSuccessor(root,closest.val);
        for(int i=k-1;i>0;i--){
        	if(pre!=null&&suc!=null){			// if both exit, give the closer one
        		double left=Math.abs(target-pre.val);
        		double right=Math.abs(target-suc.val);
        		if(left<right){
        			res.add(pre.val);
        			pre=getPredecessor(root,pre.val);
        		} else {
        			res.add(suc.val);
        			suc=getSuccessor(root,suc.val);
        		}
        	} else if(pre!=null){		// if only predecessor exists, add one by one
        		res.add(pre.val);
        		pre=getPredecessor(root,pre.val);
        	} else {					// if only successor exists, add one by one
        		res.add(suc.val);
        		suc=getSuccessor(root,suc.val);
        	}
        }
        return res;
    }
    
    private TreeNode getSuccessor(TreeNode root,int target){ 
    	if(root==null)return root;
    	TreeNode successor=null,curr=root;
    	while(curr!=null){
    		if(curr.val>target){
    			successor=curr;
    			curr=curr.left;
    		}
    		else curr=curr.right;
    	}
    	return successor;
    }
    
    private TreeNode getPredecessor(TreeNode root,int target){
    	if(root==null)return root;
    	TreeNode predecessor=null,curr=root;
    	while(curr!=null){
    		if(curr.val<target){
    			predecessor=curr;
    			curr=curr.right;
    		}
    		else curr=curr.left;
    	}
    	return predecessor;
    }
}
