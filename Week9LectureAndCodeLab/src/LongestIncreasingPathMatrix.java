/**
 * Created by liukx08 on 5/19/2017.
 */
public class LongestIncreasingPathMatrix {
    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, longestIncreasingPath(matrix, i, j, m, n, dp));
            }
        }
        return max;
    }

    private int longestIncreasingPath(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 1;
        for(int[] dir : DIRS){
            int x = i + dir[0], y = j + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, 1 + longestIncreasingPath(matrix, x, y, m, n, dp));
            }
        }
        dp[i][j] = max;
        return max;
    }
}
