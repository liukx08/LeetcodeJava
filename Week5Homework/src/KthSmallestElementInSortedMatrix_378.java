import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by liukx08 on 4/23/2017.
 *      find a boarder that all the elements in the upper left part are
 *      less than or equal to target value; and all the elements in
 *      the lower right part are larger than target value
 *        _ _ _ _ _ _
 *       |_|_|_|_|_|*|
 *       |_|_|_|*|*|_|
 *       |_|_|_|*|_|_|
 *       |_|*|*|_|_|_|
 *       |*|_|_|_|_|_|
 *       |*|_|_|_|_|_|
 */
public class KthSmallestElementInSortedMatrix_378 {
    // Use minHeap
    public int kthSmallestHeap(int[][] matrix,int k){
        int n = matrix.length;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i = 0; i < n; i++) {
            minHeap.offer(new int[]{i, 0, matrix[i][0]});
        }
        for(int i = 0; i < k - 1; i++) {
            int[] curr = minHeap.poll();
            if(curr[1] < n - 1) {
                minHeap.offer(new int[]{curr[0], curr[1] + 1, matrix[curr[0]][curr[1] + 1]});
            }
        }
        return minHeap.poll()[2];
    }


    // revised binary search:
    // 1. start from smallest and largest value
    // 2. find the rank of mid value
    // 3. according to target rank k, move lower or upper bound
    // 4. repeat until converged
    public int kthSmallest(int[][] matrix,int k){
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n-1][n-1];
        while(low < high){
            int mid = (low+high) >>> 1;
            int rank = findRank(matrix, mid);
            if(rank < k) {
                low = mid + 1;
            }
            else high = mid;
        }
        return low;
    }
    // locate rank of val
    private int findRank(int[][] matrix,int val){
        int rank = 0,n = matrix.length;
        // start from left bottom element
        int i = n - 1, j = 0;
        while(i >= 0 && j < n){
            // val < element -> move up
            if(matrix[i][j] > val) {
                i--;
            }
            // val >= element -> move right
            else {
                j++;
                rank += i + 1;
            }
        }
        return rank;
    }
}
