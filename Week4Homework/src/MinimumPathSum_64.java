/**
 * Created by liukx08 on 4/16/2017.
 */
public class MinimumPathSum_64 {
    // DP
    public int minPathSumDP(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] count = new int[grid.length][grid[0].length];
        count[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) {
            count[i][0] = count[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++) {
            count[0][i] = count[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                count[i][j] = Math.min(count[i - 1][j], count[i][j - 1]) + grid[i][j];
            }
        }
        return count[count.length - 1][count[0].length - 1];
    }
}
