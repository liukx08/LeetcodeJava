import java.util.Arrays;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class CombinationSum_377 {
    // dp
    public int combinationSum4DP(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] count = new int[target + 1];
        count[0] = 1;
        for(int i = 0; i < count.length; i++) {
            for(int num : nums) {
                if(i + num < count.length) {
                    count[i + num] += count[i];
                }
            }
        }
        return count[target];
    }
    // memorized search
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] count = new int[target + 1];
        Arrays.fill(count, -1);
        count[0] = 1;
        return helper(nums, count, target);
    }
    private int helper(int[] nums, int[] count, int target) {
        if(count[target] != -1) {      //base case, look for result in cache
            return count[target];
        }
        int res = 0;
        for(int i : nums) {
            if(i <= target) {       // pruning
                res += helper(nums, count, target - i); // recursion
            }
        }
        count[target] = res;
        return res;
    }
}
