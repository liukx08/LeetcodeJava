package leetcode;

public class ConvertSortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        int mid=(0+nums.length-1)>>>1;
        TreeNode root=new TreeNode(nums[mid]);
        sortedArrayToBST(root,nums,0,mid,nums.length-1);
        return root;
    }
    
    private void sortedArrayToBST(TreeNode root,int[] nums,int low,int mid,int high){
    	if(mid==low&&mid==high)return;
    	int left=(low+mid)>>>1;
    	int right=(mid+1+high)>>>1;
    	if(mid>low){
    		root.left=new TreeNode(nums[left]);
    		sortedArrayToBST(root.left,nums,low,left,mid-1);
    	}
    	if(mid<high){
    		root.right=new TreeNode(nums[right]);
    		sortedArrayToBST(root.right,nums,mid+1,right,high);
    	}
    }
}
