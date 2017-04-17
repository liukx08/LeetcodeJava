/**
 * Created by liukx08 on 4/16/2017.
 *              _| i+2
 *            _| i+1
 *          _| i        i to i + 1  or  i to i + 2
 */
public class ClimbingStairs_70 {
    // DP
    public int climbStairs(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        for(int i = 0; i < n; i++) {
            count[i + 1] += count[i];
            if(i != n - 1) count[i + 2] += count[i];
        }
        return count[n];
    }
}
