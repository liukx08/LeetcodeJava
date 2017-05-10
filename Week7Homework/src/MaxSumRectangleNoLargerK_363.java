import java.util.TreeSet;

/**
 * Created by liukx08 on 5/9/2017.
 */
public class MaxSumRectangleNoLargerK_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = Math.min(matrix.length, matrix[0].length);
        int n = Math.max(matrix.length, matrix[0].length);
        boolean transpose = matrix[0].length < matrix.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            int[] row = new int[n];
            for(int j = i; j < m; j++) {
                TreeSet<Integer> preSum= new TreeSet<>();
                int cum = 0;
                preSum.add(cum);
                for(int l = 0; l < n; l++) {
                    row[l] += transpose ? matrix[l][j] : matrix[j][l];
                    cum += row[l];
                    Integer curr = preSum.ceiling(cum - k);
                    if(curr != null) {
                        max = Math.max(max, cum - curr);
                    }
                    preSum.add(cum);
                }
            }
        }
        return max;
    }
}
