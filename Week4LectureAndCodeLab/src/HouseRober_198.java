import java.util.Arrays;

/**
 * Created by liukx08 on 4/16/2017.
 */
public class HouseRober_198 {
    // memorized search
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] count = new int[nums.length];
        Arrays.fill(count, -1);
        return rob(nums, nums.length - 1, count);
    }

    private int rob(int[] nums, int curr, int[] count) {
        if(curr == -1) {
            return 0;
        }
        if(curr == 0) {
            return nums[0];
        }
        if(count[curr] != -1) { // look for result in cache
            return count[curr];
        }
        // induction rule
        count[curr] = Math.max(rob(nums, curr - 2, count) + nums[curr], rob(nums, curr - 1, count));
        return count[curr];
    }
    // DP
    public int robDP(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int lastlast = 0, last = nums[0]; // maximum value from start to lastlast and last house
        for(int i = 1; i < nums.length; i++) {
            int curr = Math.max(lastlast + nums[i], last);  // induction
            lastlast = last;    //
            last = curr;
        }
        return last;
    }
}
