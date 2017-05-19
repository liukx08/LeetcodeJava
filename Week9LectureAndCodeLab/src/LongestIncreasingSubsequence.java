import java.util.Arrays;

/**
 * Created by liukx08 on 5/19/2017.
 */
public class LongestIncreasingSubsequence {
    // naive method
    public int length(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int len = 1;
        for(int i = 0; i < dp.length; i++) {
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    // binary search, record the smallest tail numbers of subsequence with the same length

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++) {
            int idx = Arrays.binarySearch(nums, 0, maxLen, nums[i]);
            if(idx < 0) {
                idx = - idx - 1;
            }
            maxLen = Math.max(maxLen, idx + 1);
            nums[idx] = nums[i];
        }
        return maxLen;
    }
}
