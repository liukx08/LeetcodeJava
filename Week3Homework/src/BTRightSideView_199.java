/**
 * Created by liukx08 on 4/9/2017.
 * A BFS method using queue was implemented in ~/Week2Homework/src/week2homework
 * Here is the DFS method
 */
import java.util.ArrayList;
import java.util.List;

public class BTRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res=new ArrayList<>();
        rightSideView(root,res,0);
        return res;
    }
    // level is a controller to ensure each level only one element is added
    private void rightSideView(TreeNode root,List<Integer> list,int level){
        if(root==null)return;   // base case
        if(list.size()==level)list.add(root.val);   // use controller to ensure only the first element is added
        rightSideView(root.right,list,level+1); // recursion on right child first to ensure the very most right elements is added
        rightSideView(root.left,list,level+1);
    }
}
