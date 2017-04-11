import java.util.PriorityQueue;

/**
 * Created by liukx08 on 4/11/2017.
 */
public class KthSmallestInSortedMatrix_378 {
    // binary search
    public int kthsmallest(int[][] matrix,int k){
        if(matrix==null||matrix.length==0)return Integer.MIN_VALUE;
        int n=matrix.length;
        int low=matrix[0][0],high=matrix[n-1][n-1];
        while(low<high){
            int mid=(low+high)>>>1;
            int rank=findRank(matrix,mid);  // find the rank of middle value
            if(rank<k)low=mid+1;    // if < k, increase value
            else high=mid;  // if > k, decrease value
        }   // until converge
        return low;
    }

    private int findRank(int[][] matrix,int val){
        int rank=0,n=matrix.length;
        int i=n-1,j=0;
        while(i>=0&&j<n){
            if(matrix[i][j]>val)i--;
            else {
                j++;
                rank+=i+1;
            }
        }
        return rank;
    }
    // use min heap
    public int kthSmallest(int[][] matrix,int k){
        if(matrix==null||matrix.length==0)return Integer.MIN_VALUE;
        int n=matrix.length;
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<n;i++){
            queue.offer(new int[]{i,0,matrix[i][0]});
        }
        for(int i=0;i<k-1;i++){
            int[] tmp=queue.poll();
            if(tmp[1]<n-1)queue.offer(new int[]{tmp[0],tmp[1]+1,matrix[tmp[0]][tmp[1]+1]});
        }
        return queue.poll()[2];
    }
}
