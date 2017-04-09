/**
 * Created by liukx08 on 4/9/2017.
 */
public class MatrixLongestIncreasingPath_329 {
    // save four search direction
    private static final int[][] DIRS=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    // use helper function
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0; // corner case
        int m=matrix.length,n=matrix[0].length; // dimension
        int[][] dp=new int[m][n];   // initialize cache
        int max=1;
        // for loop traversal
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,longestIncreasingPath(matrix,i,j,m,n,dp));
            }
        }
        return max;
    }
    // dp is a cache to store calculated results to avoid redundant calculations
    private int longestIncreasingPath(int[][] matrix,int i,int j,int m,int n,int[][] dp){
        if(dp[i][j]!=0)return dp[i][j]; // search in cache, return value if calculated
        int max=1;
        for(int[] dir:DIRS){    // search in four directions
            int x=i+dir[0],y=j+dir[1];
            if(x<0||x>=m||y<0||y>=n||matrix[x][y]<=matrix[i][j])continue; // skip if out of bound/no increment
            int tmp=1+longestIncreasingPath(matrix,x,y,m,n,dp); // DFS in this direction
            max=Math.max(max,tmp);  // update max value
        }
        dp[i][j]=max;   // update cache
        return max;
    }
}
