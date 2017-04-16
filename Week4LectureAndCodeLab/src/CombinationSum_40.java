import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liukx08 on 4/15/2017.
 *                               8
 *             1/       1/  2/  5|  6\  7\
 *             7        X   6    3   2   1
 *      1/   2/ 5| 6\ 7\  5/ 6\
 *      6    5   2  1  0  1   0
 *  2/ 5| 6\ 5|        V      V
 *  4   1  0  0
 *         V  V
 */
public class CombinationSum_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        combinationSum2(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void combinationSum2(int[] candidates, List<List<Integer>> res, List<Integer> ans, int target, int start) {
        if(target == 0) {   // step 2: base case
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(target < candidates[i] || (i > start && candidates[i] == candidates[i-1])) { // pruning
                continue;
            }
            ans.add(candidates[i]);     // step 1: add/next level/remove
            combinationSum2(candidates, res, ans, target - candidates[i], i+1); // step 1
            ans.remove(ans.size()-1);   // step 1
        }
    }
}
