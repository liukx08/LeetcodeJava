import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukx08 on 4/23/2017.
 */
public class PathSumIII_437 {
    int count = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, 0, sum, map);
        return count;
    }
    // record preSum
    private void helper(TreeNode root, int curSum, int target, Map<Integer, Integer> map) {
        if(root == null) {
            return;
        }
        // if curSum - preSum == target, count
        curSum += root.val;
        if(map.containsKey(curSum - target)) {
            count += map.get(curSum - target);
        }
        // add curSum to preSum, go to next level, remove curSum
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        helper(root.left, curSum, target, map);
        helper(root.right, curSum, target, map);
        map.put(curSum, map.get(curSum) - 1);
    }

    // method 2: count path sum starting from every node
    public int pathSumIII(TreeNode root, int sum) {
        int res = 0;
        res = onePath(root, sum) + pathSumIII(root.left, sum) + pathSumIII(root.right, sum);
        return res;
    }
    // count path sum starting from one node
    private int onePath(TreeNode root, int sum) {
        int res = 0;
        if(root == null) {
            return res;
        }
        if(sum == root.val) {
            res++;
        }
        res += onePath(root.left, sum - root.val);
        res += onePath(root.right, sum - root.val);
        return res;
    }
}
