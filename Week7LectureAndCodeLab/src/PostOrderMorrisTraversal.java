import java.util.LinkedList;
import java.util.List;

/**
 * Created by liukx08 on 5/4/2017.
 */
public class PostOrderMorrisTraversal {
    public List<Integer> postOrderMorrisTraversal(InOrderMorrisTraversal.TreeNode root) {
        List<Integer> res = new LinkedList<>();
        InOrderMorrisTraversal.TreeNode curr = root, successor = null;
        while(curr != null) {
            if(curr.right == null) {
                res.add(0, curr.val);
                curr = curr.left;
            } else {
                successor = curr.right;
                while(successor.left != null && successor.left != curr) {
                    successor = successor.left;
                }
                if(successor.left == null) {
                    successor.left = curr;
                    res.add(0, curr.val);
                    curr = curr.right;
                } else {
                    successor.left = null;
                    curr = curr.left;
                }
            }
        }
        return res;
    }
}
