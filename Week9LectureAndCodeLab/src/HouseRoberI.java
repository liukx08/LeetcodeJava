/**
 * Created by liukx08 on 5/19/2017.
 */
public class HouseRoberI {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int lastlast = 0, last = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int curr = Math.max(lastlast + nums[i], last);
            lastlast = last;
            last = curr;
        }
        return last;
    }
}
