package week3;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by liukx08 on 4/8/2017.
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)return res;
        helper(res,new ArrayList<Integer>(),nums,new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> list,List<Integer> path,int[] nums,boolean[] isVisited){
        // base/corner case
        if(path.size()==nums.length){
            list.add(new ArrayList(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            // current level, add current element
            if(isVisited[i])continue;   // controller
            path.add(nums[i]);
            isVisited[i]=true;
            // next level
            helper(list,path,nums,isVisited);
            // current level, remove current element
            path.remove(path.size()-1);
            isVisited[i]=false;
        }
    }
}
