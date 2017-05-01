/**
 * Created by liukx08 on 5/1/2017.
 */
public class WiggleSort_280 {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if((i & 1) == 0 && i + 1 < nums.length && nums[i] > nums[i + 1]) {
                swap(nums, i);
            } else if((i & 1) == 1 && i + 1 < nums.length && nums[i] < nums[i + 1]) {
                swap(nums, i);
            }
        }
    }

    public void swap(int[] nums, int i) {
        nums[i] ^= nums[i + 1];
        nums[i + 1] ^= nums[i];
        nums[i] ^= nums[i + 1];
    }
}
