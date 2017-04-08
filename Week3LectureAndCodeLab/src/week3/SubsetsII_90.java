package week3;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by liukx08 on 4/8/2017.
 */
public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)return res;
        Arrays.sort(nums);
        helper(res,new ArrayList<Integer>(),nums,0);
        return res;
    }

    private void helper(List<List<Integer>> list,List<Integer> path,int[] nums,int pos){
        list.add(new ArrayList(path));
        // subsets of A: A[i]+ subsets of A/A[i]; sort first, if A[i]=A[i-1], skip i
        for(int i=pos;i<nums.length;i++){
            // current level, add current element
            if(i>pos&&nums[i]==nums[i-1])continue;
            path.add(nums[i]);
            // next level
            helper(list,path,nums, i+1);
            // current level, remove current element
            path.remove(path.size()-1);
        }
    }
}
