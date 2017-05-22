/**
 * Created by liukx08 on 5/22/2017.
 */
public class BestTimeStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        if(k >= prices.length / 2) {
            int profit = 0;
            for(int i = 1; i < len; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }
        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            int max = - prices[0];
            for(int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
                max = Math.max(max, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }
}
