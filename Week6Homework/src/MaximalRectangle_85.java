import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 4/30/2017.
 */
public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n + 1];
        int max = 0;
        // do maximal rectangle in histogram line by line
        for(int row = 0; row < m; row++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i <= n; i++) {
                if(i != n) {
                    height[i] = matrix[row][i] == '1' ? (height[i] + 1) : 0;
                }
                while(!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    int h = height[stack.pop()];
                    int leftIdx = stack.isEmpty() ? 0 : (stack.peek() + 1);
                    max = Math.max(max, (i - leftIdx) * h);
                }
                stack.push(i);
            }
        }
        return max;
    }
}
