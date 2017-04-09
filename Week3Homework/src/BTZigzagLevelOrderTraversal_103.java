import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liukx08 on 4/8/2017.
 */
public class BTZigzagLevelOrderTraversal_103 {
    // use recursion for DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        zigzagLevelOrder(root,res,1);
        return res;
    }
    // helper function: level is controller determining the output order
    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> list,int level){
        if(root==null)return;   // base case
        if(list.size()<level)list.add(new LinkedList<Integer>());   // new level
        if((level&1)==1)list.get(level-1).add(root.val);    // process current node, use level to control output order
        else list.get(level-1).add(0,root.val);     // ...
        zigzagLevelOrder(root.left,list,level+1);   // next level recursion
        zigzagLevelOrder(root.right,list,level+1);  // next level recursion
    }

    // use queue, BFS, use flag to track level
    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        res.add(new LinkedList<Integer>()); // list for root level
        int flag=1,count=1,next=2;
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            count--;
            if(flag==1)res.get(res.size()-1).add(curr.val); // check flag, if odd level, addLast
            else res.get(res.size()-1).add(0,curr.val); // if even level addFirst
            if(curr.left!=null)queue.offer(curr.left);  // enqueue curr TreeNode's children
            else next--;
            if(curr.right!=null)queue.offer(curr.right);
            else next--;
            if(count==0){   // finish traversing this level
                if(!queue.isEmpty())res.add(new ArrayList<Integer>()); // add list for next level
                flag^=1;    // flip level flag
                count=next; // load elements number of next level
                next=next*2;    // update elements number of next level
            }
        }
        return res;
    }
}
