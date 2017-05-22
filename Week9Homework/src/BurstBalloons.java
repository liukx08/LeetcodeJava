/**
 * Created by liukx08 on 5/22/2017.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] balloons = new int[n];
        for(int i = 1; i < n - 1; i++) {
            balloons[i] = nums[i - 1];
        }
        balloons[0] = balloons[n - 1] = 1;
        int[][] dp = new int[n][n];
        for(int k = 2; k < n; k++) {
            for(int left = 0; left < n - k; left++) {
                int right = left + k;
                for(int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], balloons[left] * balloons[i] * balloons[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
