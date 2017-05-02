import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 5/1/2017.
 *
 *      s1 < s3 < s2, from right to left, s3 as larger as possible
 *
 */
public class Find132Pattern_456 {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        // track s3 candidate
        int third = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < third) {
                return true;
            } else {
                // monotonic stack, nums[i] as s2, find the largest s3
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    third = stack.pop();
                }
                // push nums[i] as s3 candidates
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
