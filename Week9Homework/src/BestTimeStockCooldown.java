/**
 * Created by liukx08 on 5/22/2017.
 */
public class BestTimeStockCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int lastsell = 0, sell = 0, buy = - prices[0];
        for(int i = 1; i < prices.length; i++) {
            int tmp = sell;
            sell = Math.max(buy + prices[i], sell);
            buy = Math.max(lastsell - prices[i], buy);
            lastsell = tmp;
        }
        return sell;
    }
}
