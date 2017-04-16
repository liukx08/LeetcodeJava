import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/15/2017.
 *   I                     9
 *                 1/   2|  3|  4\  X
 *   II            8     7   6   5
 *             2/ 3| 4\ 3|
 *   III       6   5  4  4
 *          3/ 6\ 5|  X 4|
 *          3   0  0     V
 *          X   V  V
 */
public class CombinationSum_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 0 || n > 45 || k <=0 || k > 9) return res;      // pruning invalid k and n
        combinationSum3(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void combinationSum3(List<List<Integer>> res, List<Integer> ans, int k, int n, int start) {
        if(ans.size() == k) {   // step 2: leaf node of solution tree, last level
            if(n == 0) {
                res.add(new ArrayList<Integer>(ans));   // add a solution
            }
            return;
        }
        for(int i = start; i <= 9; i++) {
            if(i > n/2 && i != n) {     // step 3: pruning
                continue;
            }
            ans.add(i);     // step 1: add/next level/remove
            combinationSum3(res, ans, k, n - i, i+1); // step 1
            ans.remove(ans.size()-1); // step 1
        }
    }
}
