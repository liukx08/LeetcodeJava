/**
 * Created by liukx08 on 4/15/2017.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int maxEnd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            max = Math.max(maxEnd, max);
        }
        return max;
    }
}
