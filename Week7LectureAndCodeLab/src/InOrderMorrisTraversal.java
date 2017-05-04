import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 5/3/2017.
 */
public class InOrderMorrisTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inOrderMorrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root, prev = null;
        while(curr != null) {
            if(curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
