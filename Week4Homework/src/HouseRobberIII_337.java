/**
 * Created by liukx08 on 4/17/2017.
 */
public class HouseRobberIII_337 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) {
           val = x;
       }
   }

    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    // DFS: return two result, maximum including and excluding current node
    private int[] helper(TreeNode root){
        int[] res = new int[]{0,0};
        if(root == null) {
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val+left[0]+right[0];
        return res;
    }
}
