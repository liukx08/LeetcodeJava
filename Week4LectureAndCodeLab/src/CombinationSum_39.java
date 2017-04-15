import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/15/2017.
 *                  7
 *            2/  3/  6\  7\
 *            5   4    1   0
 *         2/ 3\ 3|        V
 *         3   2  1
 *      2/ 3\
 *      1   0
 *          V
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        combinationSum(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    public void combinationSum(int[] candidates, List<List<Integer>> res, List<Integer> ans, int target, int start) {
        if(target == 0) {   // step 2: base case, find a solution
            res.add(new ArrayList<Integer>(ans));
        }
        for(int i = start; i < candidates.length; i++) {
            if(target < candidates[i]) continue;    // step 3: pruning
            ans.add(candidates[i]);     // step 1: add/next level/remove
            combinationSum(candidates, res, ans, target - candidates[i], i);    // step 1
            ans.remove(ans.size()-1);   // step 1
        }
    }
}
