package week2homework;

public class DiameterBinaryTree_543 {
	// use a variable to track the diameter
	public int diameterOfBT(TreeNode root) {
		int[] dia=new int[]{0};
		depth(root,dia);
		return dia[0];
	}
	private int depth(TreeNode root,int[] dia){
	   	if(root==null)return 0;
    	int left=depth(root.left,dia);
    	int right=depth(root.right,dia);
    	if(left+right>dia[0])dia[0]=left+right;
    	return Math.max(left, right)+1;
	}
	// ugly method
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int hleft=height(root.left);
        int hright=height(root.right);
        return Math.max(Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)),hleft+hright);
    }
    
    private int height(TreeNode root){
    	if(root==null)return 0;
    	int left=height(root.left);
    	int right=height(root.right);
    	return Math.max(left, right)+1;
    }
}
