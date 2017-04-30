import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 4/30/2017.
 */
public class SlidingWindowMaximum_239 {
    // plain method, fastest
    public int[] maximumSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = Integer.MIN_VALUE;
        // find the maximum in the first window
        for(int i = 0; i < k; i++) {
            res[0] = Math.max(res[0], nums[i]);
        }
        for(int i = k; i < nums.length; i++) {
            if(nums[i] >= res[i - k]) {
                // new element is larger
                res[i - k + 1] = nums[i];
            } else if(nums[i - k] != res[i - k]) {
                // maximum element is still in the window
                res[i - k + 1] = res[i - k];
            } else {
                // search the new maximum element
                res[i - k + 1] = Integer.MIN_VALUE;
                for(int j = 0; j < k; j++) {
                    res[i - k + 1] = Math.max(res[i - k + 1], nums[i - j]);
                }
            }
        }
        return res;
    }

    // use monotonic queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        // since left elements dequeue first, if smaller, no need to record anymore
        Deque<Integer> window = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            if(!window.isEmpty() && window.peekFirst() == i - k) {
                window.removeFirst();
            }
            while(!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.removeLast();
            }
            window.addLast(i);
            if(i - k + 1 >= 0) {
                res[i - k + 1] = nums[window.peekFirst()];
            }
        }
        return res;
    }
}
