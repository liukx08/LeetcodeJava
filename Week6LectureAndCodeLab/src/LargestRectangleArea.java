import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 4/28/2017.
 */
public class LargestRectangleArea {
    // dp like method
    public int largestArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int[] leftBound = new int[heights.length];
        int[] rightBound = new int[heights.length];
        leftBound[0] = -1;
        rightBound[heights.length - 1] = heights.length;
        for(int i = 1; i < leftBound.length; i++) {
            int left = i - 1;
            while(left >=0 && heights[left] >= heights[i]) {
                left = leftBound[left];
            }
            leftBound[i] = left;
        }
        for(int i = rightBound.length - 2; i >= 0; i--) {
            int right = i + 1;
            while(right < rightBound.length && heights[right] >= heights[i]) {
                right = rightBound[right];
            }
            rightBound[i] = right;
        }
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            max = Math.max(max, (rightBound[i] - leftBound[i] - 1) * heights[i]);
        }
        return max;
    }
    // use stack
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > curHeight) {
                int height = heights[stack.pop()];
                int leftBound = stack.isEmpty() ? 0 : stack.peek() + 1;
                max = Math.max(max, (i - leftBound) * height);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleArea test = new LargestRectangleArea();
        System.out.println(test.largestRectangleArea(new int[]{2,1,2}));
    }
}
