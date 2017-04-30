/**
 * Created by liukx08 on 4/30/2017.
 */
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        // nums can store nums.length of index
        if(nums == null || nums.length == 0) {
            return 1;
        }
        // swap each index to its corresponding position
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        // find the first missing one
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
