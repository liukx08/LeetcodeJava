/**
 * Created by liukx08 on 5/8/2017.
 */
public class BinaryTreeMaximumPathSum_124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        return helper(root)[1];
    }

    private int[] helper(TreeNode root) {
        if(root == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int single = Math.max(Math.max(left[0], right[0]), 0) + root.val;
        int maxPath = Math.max(Math.max(left[1], right[1]), Math.max(left[0], 0) + Math.max(right[0], 0) + root.val);
        return new int[]{single, maxPath};
    }

    // int maxPath = Integer.MIN_VALUE;

    // public int maxPathSum(TreeNode root) {
    //     helper(root);
    //     return maxPath;
    // }

    // private int helper(TreeNode root) {
    //     if(root == null) {
    //         return 0;
    //     }
    //     int left = Math.max(0, helper(root.left));
    //     int right = Math.max(0, helper(root.right));
    //     maxPath = Math.max(maxPath, left + right + root.val);
    //     return Math.max(left, right) + root.val;
    // }
}
