/**
 * Created by liukx08 on 4/28/2017.
 *
 *      [0 0 0 0 1 1 1 1 ? ? ? ? ? 2 2 2 2 2 2]
 *               ^       ^       ^
 *              idx0    idx1    idx2
 *      if idx1 = 0, swap idx1(0) and idx0(1), idx0++, idx1++
 *      if idx1 = 2, swap idx1(2) and idx2(?), idx2--
 *      if idx1 = 1, idx1++
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        // idx0 points the tail of 0 section, idx2 points the head of 2 section, idx1 scanner
        int idx0 = 0, idx1 = 0, idx2 = nums.length - 1;
        while(idx1 <= idx2) {
            if(nums[idx1] == 0) {
                swap(nums, idx1++, idx0++);
            } else if(nums[idx1] == 2) {
                swap(nums, idx1, idx2--);
            } else {
                idx1++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
