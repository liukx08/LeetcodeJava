/**
 * Created by liukx08 on 5/23/2017.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = nums[i] + dp[0][i - 1];
        }
        for(int i = 1; i < m; i++) {
            dp[i][i] = Math.max(nums[i], dp[i - 1][i - 1]);
            for(int j = i + 1; j < n; j++) {
                int start = i, end = j, mid;
                while(start < end - 1) {
                    mid = (start + end) >>> 1;
                    if(dp[0][j] - dp[0][mid - 1] < dp[i - 1][mid - 1]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
                dp[i][j] = Math.min(Math.max(dp[i - 1][start - 1], dp[0][j] - dp[0][start - 1]), Math.max(dp[i - 1][end - 1], dp[0][j] - dp[0][end - 1]));
            }
        }
        return dp[m - 1][n - 1];
    }
}
