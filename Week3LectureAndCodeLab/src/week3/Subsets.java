package week3;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by liukx08 on 4/8/2017.
 */
public class Subsets {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)return res;
        helper(res,new ArrayList<Integer>(),nums,0);
        return res;
    }

    private void helper(List<List<Integer>> list,List<Integer> path,int[] nums,int pos){
        list.add(new ArrayList(path));
        for(int i=pos;i<nums.length;i++){
            // current level, add current element
            path.add(nums[i]);
            // next level
            helper(list,path,nums, i+1);  // cannot be pos+1, since i start from pos, i increases, subset starts from i, not pos
            // current level, remove current element
            path.remove(path.size()-1);
        }
    }
}