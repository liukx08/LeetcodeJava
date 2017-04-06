package leetcode;

import java.util.List;
import java.util.ArrayList;

public class UniqueBSTII_95 {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0)return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }
    
    private List<TreeNode> generateTrees(int low,int high){
        List<TreeNode> res=new ArrayList<TreeNode>();
        if(low>high){
            res.add(null);
            return res;
        }
        if(low==high){
            res.add(new TreeNode(low));
            return res;
        }
        for(int i=low;i<=high;i++){
            List<TreeNode> left=generateTrees(low,i-1);
            List<TreeNode> right=generateTrees(i+1,high);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode newroot=new TreeNode(i);
                    newroot.left=l;
                    newroot.right=r;
                    res.add(newroot);
                }
            }
        }
        return res;
    }
}
