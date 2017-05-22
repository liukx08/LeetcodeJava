/**
 * Created by liukx08 on 5/21/2017.
 */
public class BestTimeStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return profit;
        }
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
