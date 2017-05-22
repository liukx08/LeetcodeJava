/**
 * Created by liukx08 on 5/22/2017.
 */
public class BestTimeStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length];
        for(int i = 1; i < 3; i++) {
            int max = - prices[0];
            for(int j = 1; j < prices.length; j++) {
                int tmp = dp[j];
                dp[j] = Math.max(dp[j - 1], max + prices[j]);
                max = Math.max(max, tmp - prices[j]);
            }
        }
        return dp[prices.length - 1];
    }
}
