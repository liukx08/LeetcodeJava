/**
 * Created by liukx08 on 5/21/2017.
 */
public class BestTimeStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0, sellToday = 0;
        for(int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - prices[i - 1];
            sellToday = Math.max(sellToday + profitToday, 0);
            max = Math.max(max, sellToday);
        }
        return max;
    }

}
