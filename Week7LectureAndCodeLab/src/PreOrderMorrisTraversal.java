import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 5/4/2017.
 */
public class PreOrderMorrisTraversal {
    public List<Integer> preorderMorrisTraversal(InOrderMorrisTraversal.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        InOrderMorrisTraversal.TreeNode curr = root, prev = null;
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
                    res.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
