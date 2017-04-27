import java.util.Random;

/**
 * Created by liukx08 on 4/27/2017.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int idx = partition(nums, low, high);
            if(idx < k) {
                low = idx + 1;
                partition(nums, low, high);
            } else if (idx > k) {
                high = idx - 1;
                partition(nums, low, high);
            } else {
                break;
            }
        }
        return nums[k];
    }
    // partition function
    public int partition(int[] nums, int start, int end) {
        if(start == end) {
            return start;
        }
        // randomly chose a pivot
        Random rand = new Random();
        int idx = start + rand.nextInt(end - start + 1);
        // put pivot at end
        swap(nums, idx, end);
        int i = start;
        // partition
        for(int j = start; j <= end; j++) {
            if(nums[j] <= nums[end]) {
                swap(nums, i, j);
                i++;
            }
        }
        return i - 1;
    }
    // swap function
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        FindKthLargest test = new FindKthLargest();
        test.findKthLargest(new int[]{3, 1, 2, 4}, 2);
    }
}
