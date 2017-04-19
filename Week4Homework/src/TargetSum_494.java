/**
 * Created by liukx08 on 4/19/2017.
 *
 *      this problem can be translated into another problem
 *      sum A - sum B = S
 *      sum A + sum A - sum A - sum B = S
 *      sum A = (S + sum)/2
 *      => Partition Equal Subset Sum problem
 *
 *
 */
public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < s || ((s + sum) & 1) == 1 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }
}
