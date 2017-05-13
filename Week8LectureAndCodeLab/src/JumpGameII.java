/**
 * Created by liukx08 on 5/13/2017.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        int[] steps = new int[nums.length];
        for(int i = 0, j = 1; i < nums.length; i++) {
            while(i + nums[i] >= j && j < nums.length) {
                steps[j++] = steps[i] + 1;
            }
        }
        return steps[nums.length - 1];
    }
}
