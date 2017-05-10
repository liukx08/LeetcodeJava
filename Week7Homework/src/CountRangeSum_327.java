/**
 * Created by liukx08 on 5/9/2017.
 */
public class CountRangeSum_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for(int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return mergeCount(sums, 0, n, lower, upper);
    }

    private int mergeCount(long[] sums, int start, int end, int lower, int upper) {
        if(start == end) {
            return 0;
        }
        int mid = (start + end) >>> 1;
        int count = mergeCount(sums, start, mid, lower, upper) + mergeCount(sums, mid + 1, end, lower, upper);
        long[] arr = new long[end - start + 1];
        int lo = mid + 1, hi = mid + 1;
        for(int i = 0, j = start, k = mid + 1; i <= end - start; i++) {
            if(j > mid) {
                arr[i] = sums[k++];
            } else if(k > end || sums[j] <= sums[k]) {
                while(lo <= end && sums[lo] - sums[j] < lower) {
                    lo++;
                }
                while(hi <= end && sums[hi] - sums[j] <= upper) {
                    hi++;
                }
                count += hi - lo;
                arr[i] = sums[j++];
            } else {
                arr[i] = sums[k++];
            }
        }
        System.arraycopy(arr, 0, sums, start, end - start + 1);
        return count;
    }
}
