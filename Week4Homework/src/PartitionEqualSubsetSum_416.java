/**
 * Created by liukx08 on 4/19/2017.
 *
 *      int set S is partitioned into two sub sets A and B
 *      A + B = S
 *      sum A = sum B
 *      => sum A = sum S/2
 *
 *      01 pack problem
 *      f(i,j) = f(i-1,j) || f(i-1,j-nums[i])
 *      space optimization: use one row, update from sum to nums[i];
 */
public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        // sum of nums
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // if sum of nums is odd, sum/2 is not integer, no solution
        if((sum & 1) == 1) {
            return false;
        }
        // dp update from sum to num
        sum = sum >> 1;
        boolean[] res = new boolean[sum + 1];
        res[0] = true;
        for(int num : nums) {
            for(int i = sum; i >= num; i--) {
                res[i] = res[i] || res[i - num];
            }
        }
        return res[sum];
    }
}
