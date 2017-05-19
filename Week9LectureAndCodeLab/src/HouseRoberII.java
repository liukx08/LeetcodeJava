/**
 * Created by liukx08 on 5/19/2017.
 */
public class HouseRoberII {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

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
