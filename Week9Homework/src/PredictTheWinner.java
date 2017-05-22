/**
 * Created by liukx08 on 5/22/2017.
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int[][] val = new int[n][n];
        for(int i = 0; i < n; i++) {
            val[i][i] = nums[i];
        }
        for(int k = 1; k < n; k++) {
            for(int i = 0, j = i + k; j < n; i++, j++) {
                val[i][j] = Math.max(nums[i] - val[i + 1][j], nums[j] - val[i][j - 1]);
            }
        }
        return val[0][n - 1] >= 0;
    }
}
