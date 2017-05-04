import java.util.Random;

/**
 * Created by liukx08 on 5/4/2017.
 */
public class KthLargestInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }
        Random rand = new Random();
        int idx = rand.nextInt(end - start + 1) + start;
        swap(nums, idx, end);
        idx = start;
        for(int i = start; i <= end; i++) {
            if(nums[i] <= nums[end]) {
                swap(nums, i, idx++);
            }
        }
        idx--;
        if(idx == k) {
            return nums[idx];
        }
        if(idx > k) {
            return quickSelect(nums, start, idx - 1, k);
        }
        return quickSelect(nums, idx + 1, end, k);
    }

    public void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
