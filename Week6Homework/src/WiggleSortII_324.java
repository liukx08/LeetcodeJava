/**
 * Created by liukx08 on 5/1/2017.
 */
public class WiggleSortII_324 {
    // wiggle sort
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int median = partition(nums, 0, n - 1, n / 2);
        int left = 0, right = n - 1, i = 0;
        while(i <= right) {
            if(nums[idx(i, n)] > median) {
                swap(nums, idx(left++, n), idx(i++, n));
            } else if(nums[idx(i, n)] < median){
                swap(nums, idx(right--, n), idx(i, n));
            } else {
                i++;
            }
        }
    }
    // index mapping 0,1,2,3,4,5 -> 1,3,5,0,2,4
    public int idx(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }
    // find k + 1 th smallest
    public int partition(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }
        int idx = start;
        for(int i = start; i <= end; i++) {
            if(nums[i] < nums[end]) {
                swap(nums, i, idx++);
            }
        }
        swap(nums, idx, end);
        if(idx == k) {
            return nums[k];
        } else if(idx < k) {
            return partition(nums, idx + 1, end, k);
        } else {
            return partition(nums, start, idx - 1, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
