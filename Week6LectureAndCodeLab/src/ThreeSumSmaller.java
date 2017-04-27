import java.util.Arrays;

/**
 * Created by liukx08 on 4/27/2017.
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        // sort first
        Arrays.sort(nums);
        // fixed first number
        for(int i = 0; i < len; i++) {
            // two pointer scan from both sides to center
            int start = i + 1, end = len - 1;
            while(start < end) {
                if(nums[i] + nums[start] + nums[end] < target) {
                    res += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
