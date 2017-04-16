/**
 * Created by liukx08 on 4/16/2017.
 * follow-up of house robber
 * two adjacent houses cannot be robbed at the same time
 *  i && i + 1  is impossible => no i || no i + 1
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        // maximum of (no i) and (no i + 1)
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    // DP solution of house robber
    private int rob(int[] nums, int start, int end) {
        int lastlast = 0, last = nums[start];
        for(int i = start + 1; i <= end; i++) {
            int curr = Math.max(lastlast + nums[i], last);
            lastlast = last;
            last = curr;
        }
        return last;
    }
}
