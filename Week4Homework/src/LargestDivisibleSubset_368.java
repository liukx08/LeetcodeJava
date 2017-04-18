import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liukx08 on 4/17/2017.
 *          If a new number can be divided by the largest number
 *          in the subset, it can also be divided by others.
 */
public class LargestDivisibleSubset_368 {
    // DP
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int n = nums.length;
        int[] count = new int[n]; // store the size of the largest subset
        int[] pre = new int[n]; // store the index of last element in the largest subset (like a linked list)
        Arrays.sort(nums);  // sort first
        int max = 0, idx = -1;  // track the largest subset and its head index
        for(int i = 0; i < n; i++) {
            count[i] = 1;   // initialize the subset size to 1 (only contains nums[i] itself)
            pre[i] = -1;    // no last element
            for(int j = i - 1; j >= 0; j--) {
                // found a divisible pair, update the largest subset including nums[i]
                if(nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            // update the maximum subset
            if(count[i] > max) {
                max = count[i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(idx != -1) {
            res.add(nums[idx]);
            idx = pre[idx];
        }
        return res;
    }
}
