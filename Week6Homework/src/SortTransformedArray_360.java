import java.util.Arrays;

/**
 * Created by liukx08 on 4/30/2017.
 */
public class SortTransformedArray_360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        int[] val = new int[nums.length];
        // calculate value first
        for(int i = 0; i < nums.length; i++) {
            val[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        // only c != 0, constant
        if(a == 0 && b == 0) {
            return val;
        }
        // a = 0, linear
        if(a == 0) {
            if(b > 0) {
                return val;
            } else {
                for(int i = 0; i < res.length; i++) {
                    res[i] = val[nums.length - i - 1];
                }
                return res;
            }
        }
        // parabolic from side to center
        int i = 0, j = nums.length - 1;
        if(a > 0) {
            for(int idx = res.length - 1; idx >= 0; idx--) {
                if(val[i] > val[j]) {
                    res[idx] = val[i];
                    i++;
                } else {
                    res[idx] = val[j];
                    j--;
                }
            }
        } else {
            for(int idx = 0; idx < nums.length; idx++) {
                if(val[i] > val[j]) {
                    res[idx] = val[j];
                    j--;
                } else {
                    res[idx] = val[i];
                    i++;
                }
            }
        }
        return res;
    }
}
