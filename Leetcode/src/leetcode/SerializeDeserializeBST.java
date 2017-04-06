package leetcode;

import java.util.Deque;
import java.util.ArrayDeque;

public class SerializeDeserializeBST {

    // Encodes a tree to a single string.
	// Use preorder traversal, use "space" to delimit words
    public String serialize(TreeNode root) {
        if(root==null)return "null";
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
        StringBuilder str=new StringBuilder();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode curr=stack.pop();
        	str.append(curr.val+" ");
        	if(curr.right!=null)stack.push(curr.right);
        	if(curr.left!=null)stack.push(curr.left);
        }
        return new String(str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	// parse strings to integer array first
        if(data.equals("null"))return null;
        String[] str=data.split(" ");
        int[] all=new int[str.length];
        for(int i=0;i<all.length;i++){
        	all[i]=Integer.parseInt(str[i]);
        }
        // build BST from a preorder integer array
        return buildTree(all,0,all.length-1);
    }
    
    private TreeNode buildTree(int[] nums,int l,int h){
    	if(h<l)return null;// base case
    	TreeNode root=new TreeNode(nums[l]);// the first element is root
    	int i=l+1;	
    	while(i<=h&&nums[i]<nums[l])i++; // find the left subtree range 
    	root.left=buildTree(nums,l+1,i-1);	// build left subtree recursively
    	root.right=buildTree(nums,i,h);	// build right subtree recursively
    	return root;
    }
}
