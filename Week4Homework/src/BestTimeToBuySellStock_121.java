/**
 * Created by liukx08 on 4/16/2017.
 *
 *
 */
public class BestTimeToBuySellStock_121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0, sellToday = 0;  // Day 1: no profit, max profit = 0
        for(int i = 1; i < prices.length; i++) {
            int today = prices[i] - prices[i - 1];  // today's profit
            sellToday = Math.max(sellToday + today, 0); // update current trading position, if no profit, reset position
            max = Math.max(max, sellToday); // update max profit
        }
        return max;
    }
}
