/**
 * Created by liukx08 on 4/9/2017.
 */
import java.util.*;

public class Matrix01_542 {
    // BFS search
    private static final int[][] DIRS=new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; // search direction

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix){
        if(matrix==null||matrix.size()==0||matrix.get(0).size()==0);    // base case
        int m=matrix.size(),n=matrix.get(0).size();
        Deque<int[]> queue=new ArrayDeque<>();  // queue for BFS
        // initialize
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix.get(i).get(j)==0)queue.offer(new int[]{i,j}); // update those 0 elements, add them into queue
                else matrix.get(i).set(j,Integer.MAX_VALUE);    // mark those 1 elements
            }
        }
        // search adjacent elements of those calculated elements
        while(!queue.isEmpty()){
            int[] x=queue.poll();
            for(int[] dir:DIRS){
                int i=x[0]+dir[0];
                int j=x[1]+dir[1];
                if(i<0||i>=m||j<0||j>=n||matrix.get(i).get(j)!=Integer.MAX_VALUE)continue;
                queue.offer(new int[]{i,j});
                matrix.get(i).set(j,matrix.get(x[0]).get(x[1])+1);
            }
        }
        return matrix;
    }


// DFS: bug!
/*    private static final int[][] DIRS=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> res=new ArrayList<>();
        if(matrix==null||matrix.size()==0||matrix.get(0).size()==0)return res;
        int m=matrix.size(),n=matrix.get(0).size();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix.get(i).get(j)==0)dp[i][j]=0;
                else dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==0)continue;
                updateMatrix(dp,i,j,m,n,new boolean[m][n]);
            }
        }
        for(int i=0;i<m;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(dp[i][j]);
            }
            res.add(row);
        }
        return res;
    }

    private void updateMatrix(int[][] ans,int i,int j,int m,int n,boolean[][] isVisited){
        for(int[] dir:DIRS){
            int x=i+dir[0],y=j+dir[1];
            if(x<0||x>=m||y<0||y>=n)continue;
            if(ans[x][y]==0){
                ans[i][j]=1;
                return;
            }
            if(isVisited[x][y]&&ans[x][y]==Integer.MAX_VALUE)continue;
            isVisited[i][j]=true;
            updateMatrix(ans,x,y,m,n,isVisited);
            ans[i][j]=Math.min(ans[i][j],ans[x][y]+1);
            isVisited[i][j]=false;
        }
    }*/

    public static void main(String[] args){
        Matrix01_542 test=new Matrix01_542();
        List<List<Integer>> matrix=new ArrayList<>();
        matrix.add(Arrays.asList(0,0,0));
        matrix.add(Arrays.asList(0,1,0));
        matrix.add(Arrays.asList(1,1,1));
/*        matrix.add(Arrays.asList(0,0,1,0,1,1,1,0,1,1));
        matrix.add(Arrays.asList(1,1,1,1,0,1,1,1,1,1));
        matrix.add(Arrays.asList(1,1,1,1,1,0,0,0,1,1));
        matrix.add(Arrays.asList(1,0,1,0,1,1,1,0,1,1));
        matrix.add(Arrays.asList(0,0,1,1,1,0,1,1,1,1));
        matrix.add(Arrays.asList(1,0,1,1,1,1,1,1,1,1));
        matrix.add(Arrays.asList(1,1,1,1,0,1,0,1,0,1));
        matrix.add(Arrays.asList(0,1,0,0,0,1,0,0,1,1));
        matrix.add(Arrays.asList(1,1,1,0,1,1,0,1,0,1));
        matrix.add(Arrays.asList(1,0,1,1,1,0,1,1,1,0));*/
        test.updateMatrix(matrix);
    }
}
