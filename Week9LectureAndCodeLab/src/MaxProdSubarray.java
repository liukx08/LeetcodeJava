/**
 * Created by liukx08 on 5/19/2017.
 */
public class MaxProdSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
