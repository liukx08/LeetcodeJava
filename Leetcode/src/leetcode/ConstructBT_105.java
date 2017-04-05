package leetcode;

public class ConstructBT_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,0,inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder,int[] inorder,int pre,int inlow,int inhigh){
    	if(pre>preorder.length-1||inlow>inhigh)return null;
    	TreeNode root=new TreeNode(preorder[pre]);
    	int index;
    	for(index=inlow;index<=inhigh;index++){
    		if(inorder[index]==preorder[pre])break;
    	}
    	root.left=buildTree(preorder,inorder,pre+1,inlow,index-1);
    	root.right=buildTree(preorder,inorder,pre+1+index-inlow,index+1,inhigh);
    	return root;
    }
}
