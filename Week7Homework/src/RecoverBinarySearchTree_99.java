/**
 * Created by liukx08 on 5/9/2017.
 */
public class RecoverBinarySearchTree_99 {
       public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) {
           val = x;
       }
    }
    // Morris traversal
    public void recoverTree(TreeNode root) {
        TreeNode curr = root, prev = null, first = null, second = null;
        while(curr != null) {
            if(curr.left == null) {
                if(prev != null && curr.val < prev.val) {
                    if(first == null) {
                        first = prev;
                        second = curr;
                    } else {
                        second = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if(pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    if(curr.val < prev.val) {
                        if(first == null) {
                            first = prev;
                            second = curr;
                        } else {
                            second = curr;
                        }
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
