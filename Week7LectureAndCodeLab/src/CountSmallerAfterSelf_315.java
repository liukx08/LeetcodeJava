import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liukx08 on 5/7/2017.
 */
public class CountSmallerAfterSelf_315 {
    // build a binary search tree, count the number of smaller nodes during building
    class TreeNode {
        int val;
        // size of left subtree
        int numOfLeft = 0;
        // count duplicates
        int duplicate = 1;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        Integer[] res = new Integer[nums.length];
        TreeNode root = null;
        for(int i = res.length - 1; i >= 0; i--) {
            root = insert(root, res, i, nums[i], 0);
        }
        return Arrays.asList(res);
    }

    private TreeNode insert(TreeNode root, Integer[] res, int idx, int num, int preSum) {
        if(root == null) {
            root = new TreeNode(num);
            res[idx] = preSum;
        } else if(root.val == num) {
            root.duplicate++;
            res[idx] = preSum + root.numOfLeft;
        } else if(root.val > num) {
            root.numOfLeft++;
            root.left = insert(root.left, res, idx, num, preSum);
        } else {
            root.right = insert(root.right, res, idx, num, preSum + root.numOfLeft + root.duplicate);
        }
        return root;
    }

//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        if(nums == null || nums.length == 0) {
//            return res;
//        }
//        List<Integer> path = new ArrayList<>();
//        for(int i = nums.length - 1; i >= 0; i--) {
//            int idx = findIndex(path, nums[i]);
//            res.add(idx);
//            path.add(idx, nums[i]);
//        }
//        Collections.reverse(res);
//        return res;
//    }
//
//    private int findIndex(List<Integer> path, int target) {
//        if(path == null || path.size() == 0) {
//            return 0;
//        }
//        int start = 0;
//        int end = path.size() - 1;
//        if(target <= path.get(start)) {
//            return start;
//        }
//        if(target > path.get(end)) {
//            return end + 1;
//        }
//        while(start < end - 1) {
//            int mid = (start + end) >>> 1;
//            if(path.get(mid) >= target) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//        return end;
//    }
}
