import java.util.Arrays;

/**
 * Created by liukx08 on 5/22/2017.
 */
public class RussionDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        if(n == 1) {
            return 1;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));
        int[] nums = new int[n];
        nums[0] = envelopes[0][1];
        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            int idx = Arrays.binarySearch(nums, 0, maxLen, envelopes[i][1]);
            if(idx < 0) {
                idx = - idx - 1;
            }
            if(idx == maxLen) {
                maxLen++;
            }
            nums[idx] = envelopes[i][1];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        RussionDollEnvelopes test = new RussionDollEnvelopes();
        test.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
    }
}
