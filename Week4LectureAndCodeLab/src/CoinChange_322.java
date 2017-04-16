import java.util.Arrays;

/**
 * Created by liukx08 on 4/16/2017.
 */
public class CoinChange_322 {
    // DP
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int[] count = new int[amount + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;       // base case
        for(int i = 0; i <= amount; i++) {
            for(int coin : coins) {
                if(i + coin >= 0 && i + coin <= amount && count[i] != Integer.MAX_VALUE) {
                    count[i + coin] = Math.min(count[i + coin], count[i] + 1);
                }
            }
        }
        return count[amount] == Integer.MAX_VALUE ? -1 : count[amount];
    }

    // memorized search
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int[] count = new int[amount + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;       // base case
        return coinChange(coins, amount, count);
    }

    public int coinChange(int[] coins, int amount, int[] count) {
        if(count[amount] != Integer.MAX_VALUE) {    // check result in cache
            return count[amount];
        }
        // no result -> backtracking
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amount < coin) continue;
            int temp = coinChange(coins, amount - coin, count); // recursion to get result
            if(temp != -1) {    // result is valid only when temp != -1
                res = Math.min(res, temp + 1);
            }
        }
        count[amount] = (res == Integer.MAX_VALUE? -1 : res);   // no solution, set result as -1
        return count[amount];
    }
}
