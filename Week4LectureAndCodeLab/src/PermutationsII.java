import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liukx08 on 4/13/2017.
 * Follow-up: if there is duplicate
 *              1       1       2
 *            /   \     X     /   \
 *           11   12         21   21
 *            |    |          |    X
 *           112  121        211
 *           prune repeated case, sort first
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0)return res;
        Arrays.sort(nums);
        List<Integer> path=new ArrayList<>();
        permuteUnique(res,path,nums,new boolean[nums.length]);
        return res;
    }

    public void permuteUnique(List<List<Integer>> res,List<Integer> path,int[] nums,boolean[] visited){
        if(path.size()==nums.length){  // step 2: base case
            res.add(new ArrayList<>(path));     // step 2
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]||((i>0&&nums[i]==nums[i-1])&&!visited[i-1]))continue; // step 3: pruning
            visited[i]=true; // step 3
            path.add(nums[i]);  // step 1: add/go deep/remove
            permuteUnique(res,path,nums,visited); // step 1
            path.remove(path.size()-1); // step 1
            visited[i]=false; // step 3
        }
    }
}
