import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/13/2017.
 *          1       2       3
 *        /   \   /   \   /   \
 *       12   13 21   23 31  32
 *       |    |  |    |  |    |
 *      123  132 213 231 312 321
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0)return res;
        List<Integer> path=new ArrayList<>();
        permute(res,path,nums,new boolean[nums.length]);
        return res;
    }

    private void permute(List<List<Integer>> res,List<Integer> path,int[] nums,boolean[] visited){
        if(path.size()==nums.length){   // step 2: base case
            res.add(new ArrayList<>(path));  // step 2
            return; // step 2
        }
        for(int i=0;i<nums.length;i++){     // step 1: add/go deep/remove
            if(visited[i])continue;     // step 3: add controller, avoid revisit
            path.add(nums[i]);      //  step 1
            visited[i]=true;    // step 3
            permute(res,path,nums,visited); //  step 1
            path.remove(path.size()-1); //  step 1
            visited[i]=false;   // step 3
        }
    }
}
