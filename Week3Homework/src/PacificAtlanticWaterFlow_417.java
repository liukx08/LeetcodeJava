import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by liukx08 on 4/11/2017.
 */
public class PacificAtlanticWaterFlow_417 {
    private static final int[][] DIRS=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    // DFS
    public List<int[]> pacificAtlanticDFS(int[][] matrix) {
        List<int[]> res=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)return res;
        int m=matrix.length,n=matrix[0].length;
        boolean[][] pConnected =new boolean[m][n];
        boolean[][] aConnected =new boolean[m][n];
        for(int i=0;i<m;i++){
            DFS(matrix,i,0,m,n,Integer.MIN_VALUE,pConnected);
            DFS(matrix,i,n-1,m,n,Integer.MIN_VALUE,aConnected);
        }
        for(int i=0;i<n;i++){
            DFS(matrix,0,i,m,n,Integer.MIN_VALUE,pConnected);
            DFS(matrix,m-1,i,m,n,Integer.MIN_VALUE,aConnected);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pConnected[i][j]&&aConnected[i][j])res.add(new int[]{i,j});
            }
        }
        return res;
    }
    // need to pass height into neighbors
    private void DFS(int[][] matrix,int x,int y,int m,int n,int height,boolean[][] connect){
        if(x<0||x>=m||y<0||y>=n||connect[x][y]||matrix[x][y]<height)return;
        connect[x][y]=true;
        for(int[] dir:DIRS){
            int i=x+dir[0];
            int j=y+dir[1];
            DFS(matrix,i,j,m,n,matrix[x][y],connect);
        }
    }
    // BFS
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)return res;
        int m=matrix.length,n=matrix[0].length;
        Deque<int[]> pacific=new ArrayDeque<>();
        Deque<int[]> atlantic=new ArrayDeque<>();
        boolean[][] pConnected =new boolean[m][n];
        boolean[][] aConnected =new boolean[m][n];
        for(int i=0;i<m;i++){
            pacific.offer(new int[]{i,0});
            pConnected[i][0]=true;
            atlantic.offer(new int[]{i,n-1});
            aConnected[i][n-1]=true;
        }
        for(int i=0;i<n;i++){
            pacific.offer(new int[]{0,i});
            pConnected[0][i]=true;
            atlantic.offer(new int[]{m-1,i});
            aConnected[m-1][i]=true;
        }
        BFS(matrix,pacific,m,n,pConnected);
        BFS(matrix,atlantic,m,n,aConnected);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pConnected[i][j]&&aConnected[i][j])res.add(new int[]{i,j});
            }
        }
        return res;
    }

    private void BFS(int[][] matrix,Deque<int[]> ocean,int m,int n,boolean[][] connect){
        while(!ocean.isEmpty()){
            int[] curr=ocean.poll();
            for(int[] dir:DIRS){
                int x=curr[0]+dir[0];
                int y=curr[1]+dir[1];
                if(x<0||x>=m||y<0||y>=n||connect[x][y]||matrix[x][y]<matrix[curr[0]][curr[1]])continue;
                ocean.offer(new int[]{x,y});
                connect[x][y]=true;
            }
        }
    }
}
