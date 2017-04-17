import java.util.Arrays;

/**
 * Created by liukx08 on 4/16/2017.
 *          every n has at least one solution: n sums of 1
 *
 */
public class PerfectSquares_279 {
    // DP
    public int numSquares(int n) {
        int[] count = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;   // base case
        for(int i = 0; i < n; i++) {
            // from i, update i+1^2, i+2^2, ..., i+(sqrt(n - i))^2 (n)
            for(int j = 1; j <= (int)Math.sqrt(n - i); j++) {
                int step = j * j;
                count[i + step] = Math.min(count[i] + 1, count[i + step]);
            }
        }
        return count[n];
    }
}
