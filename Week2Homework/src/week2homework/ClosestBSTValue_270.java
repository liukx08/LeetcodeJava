package week2homework;

public class ClosestBSTValue_270 {
    public int closestValue(TreeNode root, double target) {
        double difference=Math.abs(target-root.val);
        TreeNode curr=root,res=root;
        while(curr!=null){
            if(Math.abs(target-curr.val)<difference){
                difference=Math.abs(target-curr.val);
                res=curr;
            }
            if(target<curr.val)curr=curr.left;
            else curr=curr.right;
        }
        return res.val;
    }
}
