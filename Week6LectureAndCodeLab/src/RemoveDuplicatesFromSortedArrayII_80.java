/**
 * Created by liukx08 on 4/29/2017.
 */
public class RemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length < 3) {
            return nums.length;
        }
        int i = 2;
        for(int j = 2; j < nums.length; j++) {
            if(nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII_80 test = new RemoveDuplicatesFromSortedArrayII_80();
        test.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
