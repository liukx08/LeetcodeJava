package week2homework;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths_257 {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<String>();
        if(root==null)return res;
        path(root,res,"");
        return res;
    }
	
	private void path(TreeNode root,List<String> res,String path){
		if(root.left==null&&root.right==null)res.add(path+root.val);	// path end base case
		if(root.left!=null)path(root.left,res,path+root.val+"->");		// top-down recursion
		if(root.right!=null)path(root.right,res,path+root.val+"->");	
	}
}
